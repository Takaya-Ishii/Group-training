package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Stack;
import com.example.demo.form.StackForm;
import com.example.demo.helper.StackHelper;
import com.example.demo.service.StackService;

import lombok.RequiredArgsConstructor;

/**
 * 適宜、追加・編集をお願いいたします。
 */

@Controller
@RequestMapping("/participant")
@RequiredArgsConstructor
public class DisplayController {

    private final StackService stackService;
    
	/**
	 * 受講研修詳細画面を表示
	 */
	@GetMapping("/traCourse/{id}")
	public String displayCourseDetail(@PathVariable Integer id,
			RedirectAttributes attributes, @ModelAttribute StackForm stackForm) {
		stackForm.setTraCourseID(id);
		return "participant/traCourse/detail";
	}
	
	/**
	 * 学習履歴登録の画面を表示
	 */
	@GetMapping("/traCourse/stack/save/{id}")
	public String displaySaveStack(@PathVariable Integer id , 
			@ModelAttribute StackForm stackForm, Model model) {
		stackForm.setTraCourseID(id);
		Stack traName = stackService.findTra_name(id);
		if (traName != null) {
			model.addAttribute("traName", traName);
			return "/participant/traCourse/stack/save";
		} else {
			return "redirect:/participant/traCourse";
		}
	}
	
	/**
	 * 新規登録を実行
	 */
	@PostMapping("/traCourse/stack/registration/{id}")
	public String registrationStack(@Validated StackForm stackForm,
			BindingResult bindingResult, @PathVariable Integer id ,
			RedirectAttributes attributes, Model model) {
		//バリデーションチェック
		//入力チェックNG：学習履歴登録の画面を表示
		if (bindingResult.hasErrors()) {
			Stack traName = stackService.findTra_name(id);
			model.addAttribute("traName", traName);
			model.addAttribute("errorMessage", "入力内容に誤りがあります。再度入力してください");
			return "/participant/traCourse/stack/save";
			
		} 
		//エンティティへの変換
		Stack stack = StackHelper.convertStack(stackForm);

		//登録実行
		stackService.insertStack(stack);
		return "redirect:/participant/traCourse/"+ stack.getTraCourse_ID();
	}
	
	/**
	 * 学習履歴修正・削除画面を表示
	 */
	@GetMapping("/traCourse/stack/edit/{id}/{no}")
	public String displayEditStack(@PathVariable Integer id, @PathVariable Integer no, 
			Model model, RedirectAttributes attributes) {
		Stack target = stackService.findStack(id, no);
		Stack traName = stackService.findTra_name(id);
		if (target != null) {
			
			//対象データがある場合はFormへの変換
			StackForm stackForm = StackHelper.converStackForm(target);
			stackForm.setStackNo(no);
			stackForm.setTraCourseID(id);
			
			//モデルに格納
			model.addAttribute("stackForm", stackForm);
			model.addAttribute("traName", traName);
			return "/participant/traCourse/stack/edit";
			
		} else {
			return "redirect:/participant/traCourse/detail";
		}
	}
	
	/**
	 * 学習履歴の修正
	 */
	@PostMapping("/traCourse/stack/update/{id}/{no}")
	public String updateStack(@PathVariable Integer id, @PathVariable Integer no,
			@Validated StackForm stackForm, BindingResult bindingResult,
			RedirectAttributes attributes, Model model) {
		//バリデーションチェック
		//入力チェックNG：学習履歴登録の画面を表示
		if (bindingResult.hasErrors()) {
			Stack traName = stackService.findTra_name(id);
			model.addAttribute("traName", traName);
			model.addAttribute("errorMessage", "入力内容に誤りがあります。再度入力してください");
			return "/participant/traCourse/stack/edit";
			
		}
		//エンティティへの変換
		Stack stack = StackHelper.convertStack(stackForm);
		//更新処理
		stackService.updateStack(stack);
		System.out.println(stack);
		return "redirect:/participant/traCourse/"+ stack.getTraCourse_ID();
		
	}
	
	/**
	 * 学習履歴の削除
	 */
	@PostMapping("/traCourse/stack/delete/{id}/{no}")
	public String deleteStack(@PathVariable Integer id, @PathVariable Integer no,
			RedirectAttributes attributes) {
		Stack TraCourseID = stackService.findTraCourse_ID(id);
		//削除処理
		stackService.deleteStack(id, no);
		return "redirect:/participant/traCourse/" + TraCourseID.getTraCourse_ID();
	}
	
}
