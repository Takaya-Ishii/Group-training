package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

import com.example.demo.entity.LoginUser;
import com.example.demo.entity.TraTpm;
import com.example.demo.entity.Trainfo;
import com.example.demo.form.StackForm;
import com.example.demo.helper.StackHelper;
import com.example.demo.repository.AuthenticationMapper;
import com.example.demo.service.StackService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/participant/traCourse/")
@RequiredArgsConstructor
public class StackController {
	
	@Autowired
	AuthenticationMapper authenticationMapper;

    private final StackService stackService;
 	
	/**
	 * 学習履歴登録の画面を表示
	 */
	@GetMapping("/stack/save/{traCourse_ID}")
	public String displaySaveStack(@PathVariable Integer traCourse_ID , @ModelAttribute StackForm stackForm,
			@AuthenticationPrincipal LoginUser loginUser, Model model) {
		stackForm.setTraCourseID(traCourse_ID);
		model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		Trainfo traName = stackService.findTra_name(traCourse_ID);
		if (traName != null) {
			model.addAttribute("traName", traName);
			return "/participant/traCourse/stack/save";
		} else {
			return "redirect:/error/404";
		}
	}
	
	/**
	 * 新規登録を実行
	 */
	@PostMapping("/stack/registration/{traCourse_ID}")
	public String registrationStack(@Validated StackForm stackForm,
			BindingResult bindingResult, @PathVariable Integer traCourse_ID,
			RedirectAttributes attributes, @AuthenticationPrincipal LoginUser loginUser, Model model) {
		model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		//バリデーションチェック
		//入力チェックNG：学習履歴登録の画面を表示
		if (bindingResult.hasErrors()) {
			Trainfo traName = stackService.findTra_name(traCourse_ID);
			model.addAttribute("traName", traName);
			model.addAttribute("errorMessage", "入力内容に誤りがあります。再度入力してください");
			return "/participant/traCourse/stack/save";
			
		} 
		//エンティティへの変換
		TraTpm stack = StackHelper.convertStack(stackForm);

		//登録実行
		stackService.insertStack(stack);
		return "redirect:/participant/traCourse/detail/"+ stack.getTraCourse_ID();
	}
	
	/**
	 * 学習履歴修正・削除画面を表示
	 */
	@GetMapping("/stack/edit/{traCourse_ID}/{stack_No}")
	public String displayEditStack(@PathVariable Integer traCourse_ID, @PathVariable Integer stack_No, 
			@AuthenticationPrincipal LoginUser loginUser, Model model, RedirectAttributes attributes) {
		TraTpm target = stackService.findStack(traCourse_ID, stack_No);
		Trainfo traName = stackService.findTra_name(traCourse_ID);
		model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		if (target != null) {
			
			//対象データがある場合はFormへの変換
			StackForm stackForm = StackHelper.converStackForm(target);
			stackForm.setStackNo(stack_No);
			stackForm.setTraCourseID(traCourse_ID);
			
			//モデルに格納
			model.addAttribute("stackForm", stackForm);
			model.addAttribute("traName", traName);
			return "/participant/traCourse/stack/edit";
			
		} else {
			return "redirect:/error/404";
		}
	}
	
	/**
	 * 学習履歴の修正
	 */
	@PostMapping("/stack/update/{traCourse_ID}/{stack_No}")
	public String updateStack(@PathVariable Integer traCourse_ID, @PathVariable Integer stack_No,
			@Validated StackForm stackForm, BindingResult bindingResult,
			RedirectAttributes attributes, @AuthenticationPrincipal LoginUser loginUser, Model model) {
		model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		//バリデーションチェック
		//入力チェックNG：学習履歴登録の画面を表示
		if (bindingResult.hasErrors()) {
			Trainfo traName = stackService.findTra_name(traCourse_ID);
			model.addAttribute("traName", traName);
			model.addAttribute("errorMessage", "入力内容に誤りがあります。再度入力してください");
			return "/participant/traCourse/stack/edit";
			
		}
		//エンティティへの変換
		TraTpm stack = StackHelper.convertStack(stackForm);
		//更新処理
		stackService.updateStack(stack);
		System.out.println(stack);
		return "redirect:/participant/traCourse/detail/"+ stack.getTraCourse_ID();
		
	}
	
	/**
	 * 学習履歴の削除
	 */
	@PostMapping("/stack/delete/{traCourse_ID}/{stack_No}")
	public String deleteStack(@PathVariable Integer traCourse_ID, @PathVariable Integer stack_No,
			RedirectAttributes attributes, @AuthenticationPrincipal LoginUser loginUser, Model model) {
		TraTpm traCourseID = stackService.findTraCourse_ID(traCourse_ID);
		model.addAttribute("group", authenticationMapper.selectGroupByUsername(loginUser.getUsername()));
		//削除処理
		stackService.deleteStack(traCourse_ID, stack_No);
		return "redirect:/participant/traCourse/detail/" + traCourseID.getTraCourse_ID();
	}
	
}
