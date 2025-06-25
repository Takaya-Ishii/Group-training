package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.helper.Userhelper;
import com.example.demo.service.UserService;
import com.example.demo.validation.EditValidation;
import com.example.demo.validation.InsertValidation;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserController {
	/**DI*/
	private final UserService userService;
	
	/**「ユーザー」の一覧を表示する*/
	@GetMapping("")
	public String displayAllUser(Model model) {
		model.addAttribute("user",userService.displayAllUser());
		return "User/list";
	}
	
	/**検索された「ユーザー」のID,名前,ロールを一覧表示する*/
	@PostMapping("")
    public String displaySearchedUser(@RequestParam String username,@RequestParam String account_name,Model model,RedirectAttributes attributes) {
		//usernameに対応する「username」の情報を取得する
		List<User> User= userService.displaySearchedUser(username,account_name);
		if(User != null) {
			//対象データがある場合はmodelに格納
			model.addAttribute("user", userService.displaySearchedUser(username,account_name));
			return "User/list";
			
		}else {
			//対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("userMesssage","対象のユーザーはいません");
			//リダイレクト
			return "redirect:/User";
		}
	}
	
	/**指定された「ユーザー」の詳細を表示する*/
	@GetMapping("/{username}")
	public String displayUserDetail(@PathVariable String username,Model model,RedirectAttributes attributes) {
		//usernameに対応する詳細なデータを取得(同じusernameがある場合を考慮)
		User User = userService.displayUserDetail(username);
		System.out.println(User);
		if(User != null) {
		model.addAttribute("user",userService.displayUserDetail(username));
		return "User/detail";
		}else {
			//対象のユーザーの詳細がない場合は、メッセージを表示
			attributes.addFlashAttribute("detailMessage","対象のユーザーの詳細なデータはありません");
			return "redirect:/User";
			
		}
	}
	
	/**新規登録画面を表示する*/
	@GetMapping("/save")
	public String displaySaveUser(@ModelAttribute UserForm form) {
		//新規登録画面の設定
		form.setIsNew(true);
		return "User/save";
	}
	
	/**新たな「ユーザー」を新規登録する*/
	@Transactional
	@PostMapping("/registration")
	public String registrationUser(@Validated ({InsertValidation.class}) UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		//===ここからが、バリデーションチェックです===
		// 入力に問題があるか ifで検査
		if(bindingResult.hasErrors()) {
			//ある場合、入力画面を表示します
			form.setIsNew(true);
			System.out.println("a");
			return "User/save";
		}
		//エンティティへの変換
		User User = Userhelper.convertUser(form);
		//更新処理
		userService.registrationUser(User);
		//フラッシュメッセージ
		attributes.addAttribute("updatemessage","ユーザーが新規登録されました");
		//PRGパターン
		return "redirect:/User";
	}
	
	/**編集画面を表示する*/
	@GetMapping("/edit/{username}")
	public String displayEditUser(@ModelAttribute UserForm form) {
		//新規登録画面の設定
				form.setIsNew(true);
				return "User/edit";
	}
	
	/**指定されたIDの情報を編集する*/
	@PostMapping("/update")
	public String updateUser(@Validated ({EditValidation.class})UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		//ここからバリデーションチェックです
		//入力に問題あるか ifで検査
		if(bindingResult.hasErrors()) {
			//ある場合、更新画面を表示します
			form.setIsNew(false);
			return "user/form";
		}
		//エンティティへの変換
		User User = Userhelper.convertUser(form);
		//更新処理
		userService.updateUser(User);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","ユーザー情報が更新されました");
		//PRGパターン
		return "redirect:/User";
	}
	
	//IDで指定されたユーザー情報を削除する
	@Transactional
	@GetMapping("/delete/{username}")
	public String deleteUser(@PathVariable String username,Model model,RedirectAttributes attributes) {
		//削除処理
		userService.deleteUser(username);
		//フラッシュメッセージ
		attributes.addFlashAttribute("deletemessage","ユーザーが処理されました");
		return "redirect:/User";
	}
}
