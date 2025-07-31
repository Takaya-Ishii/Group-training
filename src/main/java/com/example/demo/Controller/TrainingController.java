package com.example.demo.Controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Trainfo;
import com.example.demo.form.TraForm;
import com.example.demo.helper.TraHelper;
import com.example.demo.service.TraService;

import lombok.RequiredArgsConstructor;

/*
 * 研修管理：コントローラー
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor

public class TrainingController {

	//DI
	private final TraService traService;
	
	/*
	 * 一覧を表示させる
	 */
	@GetMapping("/admin/Training")
	public String displayAllTraining(Model model) {
		model.addAttribute("tra_list", traService.selectAllTra());
		return "admin/training/trainingList";
	}
	
	/*
	 *  研修名から研修の一覧を検索する
	 */
	@GetMapping("/admin/Training/serch")
	public String displaySerchedTraining(@RequestParam(value = "tra_name", required = false) 
			String tra_name, Model model,
			RedirectAttributes attributes) {
		
		model.addAttribute("tra_name", tra_name);
		if(tra_name != null && !tra_name.isEmpty()) {
			if(!tra_name.isEmpty()) {
				model.addAttribute("tra_list", traService.selectByNameTra(tra_name));
			} 
		}else {
			model.addAttribute("tra_list", traService.selectAllTra());
			}
		
		return "admin/training/trainingList";
	}
	 
	/*
	 * 指定されたIDの研修詳細を表示する
	 */
	@GetMapping("/admin/Training/{tra_id}")
	public String displayTrainingDetail(@PathVariable("tra_id") String tra_id, Model model) {

		model.addAttribute("tra_detail", traService.selectByIdTra(tra_id));
		return "admin/training/trainingDetail";
	}
	
	/*
	 * 新規登録画面の表示
	 */
	@GetMapping("/admin/Training/save")
	public String displaySaveTraining(@ModelAttribute("form") TraForm form, Model model) {
		
		return "admin/training/trainingNew";
	}
	
	/*
	 * 新規登録の処理
	 */
	@PostMapping("/admin/Training/registration")
	public String registrationTraining(@Validated @ModelAttribute("form") TraForm form,
			BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		
		//一意性制約による例外の処理
		try {
			//バリデーションチェック
			if(bindingResult.hasErrors()) {
				attributes.addFlashAttribute("form", form);
				model.addAttribute("errorMessage", "入力項目に誤りがあります。メッセージを確認し、再度入力をしてください。");
				return "admin/training/trainingNew";
			}
			
			Trainfo tra_mana = TraHelper.convertTra(form);
			traService.insertTra(tra_mana);
			attributes.addFlashAttribute("message", form.getTra_name() + "が追加されました。");
			return "redirect:/admin/Training";
			
		}catch(DataIntegrityViolationException e) {
			
			attributes.addFlashAttribute("form", form);
			model.addAttribute("errorMessage", "入力項目に誤りがあります。メッセージを確認し、再度入力をしてください。");
			model.addAttribute("IdErrorMessage", "既に登録されている研修IDです");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "admin/training/trainingNew";
		}
	}
	
	/*
	 * 編集画面の表示
	 */
	@GetMapping("/admin/Training/edit/{tra_id}")
	public  String displayEditTraining(@PathVariable String tra_id, Model model,
			@ModelAttribute TraForm form, BindingResult bindingResult) {
		
		model.addAttribute("form", traService.selectByIdTra(tra_id));
		return "admin/training/trainingEdit";
	}
	
	/*
	 * 編集画面の更新処理
	 */
	@PostMapping("admin/Training/update/{tra_ID}")
	public String updateTraining(@Validated @ModelAttribute("form") TraForm form,
			BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		
		//バリデーションチェック
		if(bindingResult.hasErrors()) {
			model.addAttribute("form", form);
			model.addAttribute("errorMessage", "入力項目に誤りがあります。メッセージを確認し、再度入力をしてください。");
			return "admin/training/trainingEdit";
		}
		 
		Trainfo tra_mana = TraHelper.convertTra(form);
		traService.updateTra(tra_mana);
		attributes.addFlashAttribute("message", form.getTra_id() +  "を更新しました");
		return "redirect:/admin/Training";
	}
	
	/*
	 * 詳細画面の削除処理
	 */
	@PostMapping("admin/Training/delete/{tra_id}")
	public String deleteTraining(@PathVariable String tra_id, 
			@ModelAttribute("form") TraForm form, Model model,
			RedirectAttributes attributes) {
		
		Trainfo tra_mana = traService.selectByIdTra(tra_id);
		String name = tra_mana.getTra_name();
		traService.deleteTra(tra_id);
		attributes.addFlashAttribute("message", "研修「" + name + "」を削除しました");
		return "redirect:/admin/Training";
	}
}