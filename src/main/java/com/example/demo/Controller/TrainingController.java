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

import com.example.demo.entity.Tra_Manegement;
import com.example.demo.form.TraForm;
import com.example.demo.helper.TraHelper;
import com.example.demo.service.TraService;

import lombok.RequiredArgsConstructor;

/**
 * 研修管理：コントローラー
 * */
@Controller
@RequestMapping("/Training")
@RequiredArgsConstructor

public class TrainingController {

	/*DI*/
	private final TraService traService;
	/**
	 * 一覧を表示させる
	 */
	@GetMapping
	public String TrainingList(Model model) {
		model.addAttribute("tra_list", traService.selectAllTra());
		return "tra_Manegement/list";
		
	}
	/**
	 * 指定された名前の研修詳細を表示する
	 */
	@GetMapping("/{tra_ID}")
	public String TrainingDetail(@PathVariable String tra_id, Model model,
			RedirectAttributes attributes) {
		Tra_Manegement tra = traService.selectByIdTra("tra_id");
		if(tra != null) {
			model.addAttribute("tra", traService.selectByNameTra(tra_id));
			return "Training/{tra_ID}";
		} else {
			attributes.addFlashAttribute("errorMessage", "データがありません");
			return "redirect:/Training";
		}
	}
	
	//新規登録画面の表示
	@GetMapping("/Training/save")
	public String NewTra(@ModelAttribute TraForm form) {
		form.setIsNew(true);
		return "Training/form";
	}
	
	//新規登録の処理
	@PostMapping("/Save")
	public String create(@Validated TraForm form, 
			BindingResult bindingResult, RedirectAttributes attributes) {
		
		//バリデーションチェック
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);
			return "Training/form";
		}
		
		Tra_Manegement tra_mane = TraHelper.convertTra(form);
		traService.insertTra(tra_mane);
		attributes.addFlashAttribute("message", "tra_maneが追加されました。");
		return "redirect:/Training";
	}
	
	//編集画面の表示
	@GetMapping("/Training/Edit/{tra_ID}")
	public  String Edit(@PathVariable String tra_id, Model model, RedirectAttributes attributes) {
		
		Tra_Manegement target = traService.selectByIdTra(tra_id);
		if(target != null) {
			TraForm form = TraHelper.convertTraForm(target);
			model.addAttribute("TraForm", form);
			return "Training/form";
		} else {
			return "redirect:/Training";
		}
	}
	
	//編集画面の更新処理
	@PostMapping("/Edit/{tra_ID}")
	public String Update(@Validated TraForm form, 
			BindingResult bindingResult,
			RedirectAttributes attributes) {
		
		if(bindingResult.hasErrors()) {
			form.setIsNew(false);
			return "Training/form";
		}
		
		Tra_Manegement tra_mane = TraHelper.convertTra(form);
		traService.updateTra(tra_mane);
		attributes.addFlashAttribute("message", "研修を更新しました");
		return "redirect:/Training";
	}
	
	//削除処理
	@PostMapping("/delete/{tra_ID}")
	public String Delete(@PathVariable String tra_id, RedirectAttributes attributes) {
		traService.deleteTra(tra_id);
		attributes.addFlashAttribute("message", "tra_nameを削除しました");
		return "redirect:/Training";
	}
}
