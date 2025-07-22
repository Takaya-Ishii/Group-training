package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.Status;
import com.example.demo.entity.TraCourse;
import com.example.demo.entity.TraCourseSave;
import com.example.demo.entity.TraTpm;
import com.example.demo.entity.User;
import com.example.demo.form.TraCourseSaveListForm;
import com.example.demo.helper.TraCourseHelper;
import com.example.demo.service.TraCourseService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class TraCourseController {
	
	/**DI*/
	private final TraCourseService tService;
	
	/**
	 * 受講研修一覧画面を表示します
	 */
	@GetMapping("/participant/traCourse/{uName}")
	 public String displaytraCourse(@PathVariable String uName,Model model, @AuthenticationPrincipal LoginUser loginUser) {
		 List<TraCourse> traCoList = tService.findTraCourses(uName);
		 User traUser =  tService.findTraCoUser(uName);
		 model.addAttribute("traCoList",traCoList);
		 model.addAttribute("traUser", traUser);
		 return "participant/traCourse";
	 }
	
	/**
	 * 受講研修登録画面を表示します
	 */
	@GetMapping("/admin/traCourse/save/{uName}")
	public String displaySaveCourse(@PathVariable String uName,Model model, @AuthenticationPrincipal LoginUser loginUser) {
		List<TraCourse> traCoLiSave =(tService.findTraCouForSave(uName));
		TraCourseSaveListForm tForms = new TraCourseSaveListForm();
		tForms.setSaveList(TraCourseHelper.convertTraCourseSaveForm(traCoLiSave));
		User traUser =  tService.findTraCoUser(uName);
		model.addAttribute("tForms", tForms);
		model.addAttribute("traUser", traUser);
		return "admin/traCourse/save/traCourseResist";
	}
	
	/**
	 * 受講研修登録機能
	 */
	@PostMapping("/admin/traCourse/registration")
	public String registrationCourse(@ModelAttribute("tForms") TraCourseSaveListForm form,@ModelAttribute("traUser") User user, RedirectAttributes attributes,Model model){
		 ArrayList<TraCourseSave> saveData = new ArrayList<TraCourseSave>();
		 saveData = TraCourseHelper.convertTraCourseSaveList(form);
		//比較用で登録ボタン押下前の受講状況を取得する
		 List<TraCourse> traCoSaveBefore =(tService.findTraCouForSave(user.getUsername()));
		//traCoLiSave(押下前)とsaveData（押下後）を比較しメッセージリストを作成
		 ArrayList<String> messageStrings = TraCourseHelper.traChangeCheck(saveData,traCoSaveBefore);
		 
		//登録処理
		 for(TraCourseSave data:saveData) {
			 
			//新規で追加されて受講研修IDが振られていない研修
			 if(data.getTracourse_id() == null) {
				 data.setUsername(user.getUsername());
				 //登録処理
				 tService.registNewTraCourse(data);
			 }else {				 
				 tService.reSaveTraCourse(data);
			 }
			 
		 }
		 //Listが空じゃなければメッセージ入れる
		 if(!messageStrings.isEmpty()) {
			 attributes.addFlashAttribute("messages",messageStrings);
		 }
			//リダイレクト
		return "redirect:/participant/traCourse/"+user.getUsername();

	}
	
	/**
	 * 受講研修詳細画面を表示します
	 */
	@GetMapping("/participant/traCourse/detail/{traCourse_ID}")
	public String displayCourseDetail(@PathVariable Integer traCourse_ID,Model model, @AuthenticationPrincipal LoginUser loginUser) {
		TraCourse traCourse = new TraCourse();
		List<TraTpm> traTpm = new ArrayList<> ();
		ArrayList<Status> statusAll = new ArrayList<Status>();
		statusAll = tService.findStatusAll();
		traCourse = tService.findTraCourse(traCourse_ID);
		traTpm = tService.findTraCourseTpm(traCourse_ID);
		User traUser =  tService.findTraCoUser(traCourse.getUsername());
		System.out.println(traCourse);
		model.addAttribute("traCourse", traCourse);
		model.addAttribute("traTpm", traTpm);
		model.addAttribute("statusAll", statusAll);
		model.addAttribute("traUser", traUser);
		System.out.println(tService.findTraCourseTpm(traCourse_ID));
		return "participant/traCourse/tracoursedetail";
	}
	
	/**
	 * ステータスを更新します
	 */
	@PostMapping("/participant/traCourse/{traCourse_ID}/update")
	public String updateCourseStatus(@PathVariable Integer traCourse_ID,@ModelAttribute TraCourse traCourse, RedirectAttributes attributes,Model model){
		//ステータス変更処理
		tService.saveTraCoStatus(traCourse);
		//履歴登録処理
		tService.saveTpmStatus(traCourse);
		
		return "redirect:/participant/traCourse/detail/"+traCourse_ID;
	}
	
}
