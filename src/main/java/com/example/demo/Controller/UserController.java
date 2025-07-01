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

import com.example.demo.entity.Authentication;
import com.example.demo.form.UserForm;
import com.example.demo.helper.Userhelper;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.validation.EditValidation;
import com.example.demo.validation.InsertValidation;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {
	/**DI*/
	private final UserServiceImpl userServiceImpl;
	
	/**「ユーザー」の一覧を表示する*/
	@GetMapping("/User")
	public String displayAllUser(Model model) {
		model.addAttribute("user",userServiceImpl.displayAllUser());
		return "admin/User/list";
	}
	
	/**検索された「ユーザー」のID,名前,ロールを一覧表示する*/
	@PostMapping("/User")
    public String displaySearchedUser(@RequestParam String username,@RequestParam String account_name,Model model,RedirectAttributes attributes) {
		//usernameに対応する「username」の情報を取得する
		List<Authentication> User= userServiceImpl.displaySearchedUser(username,account_name);
		if(User != null) {
			//対象データがある場合はmodelに格納
			model.addAttribute("user", userServiceImpl.displaySearchedUser(username,account_name));
			return "admin/User/list";
			
		}else {
			//対象データがない場合はフラッシュメッセージを設定
			attributes.addFlashAttribute("errorMesssage","対象のユーザーはいません");
			//リダイレクト
			return "redirect: /admin/User";
		}
	}
	
	/**指定された「ユーザー」の詳細を表示する*/
	@GetMapping("/User/{username}")
	public String displayUserDetail(@PathVariable String username,Model model,RedirectAttributes attributes) {
		//usernameに対応する詳細なデータを取得
		Authentication User = userServiceImpl.displayUserDetail(username);
		
		if(User != null) {
		model.addAttribute("user",userServiceImpl.displayUserDetail(username));
		return "admin/User/detail";
		}else {
			//対象のユーザーの詳細がない場合は、メッセージを表示
			attributes.addFlashAttribute("errorMessage","対象のユーザーの詳細なデータはありません");
			return "redirect:/admin/User";
			
		}
	}
	
	/**新規登録画面を表示する*/
	@GetMapping("/User/save")
	public String displaySaveUser(@ModelAttribute UserForm form, Model model) {
		//全てのグループの名前とグループIDをuserに入れる
		model.addAttribute("user",userServiceImpl.selectAllGroup());
		//新規登録画面の設定
		return "/admin/User/save";
	}
	
	/**新たな「ユーザー」を新規登録する*/
	@Transactional
	@PostMapping("/User/registration")
	public String registrationUser(@Validated ({InsertValidation.class}) UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		//===ここからが、バリデーションチェックです===
		// 入力に問題があるか ifで検査
		if(bindingResult.hasErrors()) {
			//ある場合、入力画面を表示します
			return "/admin/User/save";
		}
		//エンティティへの変換
		Authentication User = Userhelper.convertUser(form);
		//更新処理
		userServiceImpl.registrationUser(User);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","ユーザーが新規登録されました");
		//PRGパターン
		return "redirect:/admin/User";
	}
	
	/**編集画面を表示する*/
	@GetMapping("/User/edit/{username}")
	public String displayEditUser(@PathVariable String username,@ModelAttribute UserForm form, Model model) {
		//ユーザーIDに対応するデータを取得
		Authentication User = userServiceImpl.displayUserDetail(username);
		//対象のデータをFormに変換
		UserForm form1 = Userhelper.convertUserForm(User);
		//モデルに格納
		model.addAttribute("userForm",form1);
		//全てのグループの名前とグループIDをuserに入れる
		model.addAttribute("user",userServiceImpl.selectAllGroup());
		//編集登録画面を表示
		return "/admin/User/edit";
	}
	
	/**指定されたIDの情報を編集する*/
	@Transactional
	@PostMapping("/User/update")
	public String updateUser(@Validated ({EditValidation.class})UserForm form,BindingResult bindingResult,RedirectAttributes attributes) {
		//ここからバリデーションチェックです
		//入力に問題あるか ifで検査
		if(bindingResult.hasErrors()) {
			//ある場合、更新画面を表示します
			//System.out.println(form); 
			return "/admin/User/edit";
		}
		//エンティティへの変換
		Authentication User = Userhelper.convertUser(form);
		System.out.println(User);
		//更新処理
		userServiceImpl.updateUser(User);		
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","ユーザー情報が更新されました");
		//PRGパターン
		return "redirect:/admin/User/list";
	}
	
	//IDで指定されたユーザー情報を削除する
	@Transactional
	@GetMapping("/User/delete/{username}")
	public String deleteUser(@PathVariable String username,Model model,RedirectAttributes attributes) {
		//削除処理
		userServiceImpl.deleteUser(username);
		//フラッシュメッセージ
		attributes.addFlashAttribute("message","ユーザーが処理されました");
		return "redirect:/admin/User/list";
	}
}
