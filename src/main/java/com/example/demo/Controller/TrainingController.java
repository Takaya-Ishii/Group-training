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
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/")//←を変えるときは最初に出力するページの設定を変える
@RequiredArgsConstructor

public class TrainingController {

	/*DI*/
	private final TraService traService;
	/**
	 * 一覧を表示させる
	 */
	@GetMapping("/") // 実装時は/Trainingに変更
	public String trainingList(Model model) {
		model.addAttribute("tra_list", traService.selectAllTra());
		return "trainingList";
		
	}
	
	/**
	 *  研修名から研修の一覧を検索する
	 */
	@GetMapping("/Serch")
	public String trainingSerch(@RequestParam(value = "tra_name", required = false) String tra_name, Model model,
			RedirectAttributes attributes) {
		
		if(tra_name != null && !tra_name.isEmpty()) {
			if(!tra_name.isEmpty()) {
				model.addAttribute("tra_list", traService.selectByNameTra(tra_name));
			} 
		}else {
			model.addAttribute("tra_list", traService.selectAllTra());
			}
		
		return "trainingList";
	}
	 
	/**
	 * 指定されたIDの研修詳細を表示する
	 */
	@GetMapping("/{tra_id}")
	public String trainingDetail(@PathVariable("tra_id") String tra_id, Model model) {

		model.addAttribute("tra_detail", traService.selectByIdTra(tra_id));
		return "trainingDetail";
	}
	
	//新規登録画面の表示
	@GetMapping("/Save")
	public String trainingNew(@ModelAttribute("form") TraForm form, Model model) {
		
		return "trainingNew";
	}
	
	//新規登録の処理
	@PostMapping("/Create")
	public String trainingCreate(@Validated @ModelAttribute("form") TraForm form,
			BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		
		//バリデーションチェック
			if(bindingResult.hasErrors()) {
				attributes.addFlashAttribute("form", form);
				model.addAttribute("message", "入力項目に誤りがあります。メッセージを確認し、再度入力をしてください。");
				return "trainingNew";
			}
		
		Tra_Manegement tra_mane = TraHelper.convertTra(form);
		traService.insertTra(tra_mane);
		attributes.addFlashAttribute("message", form.getTra_name() + "が追加されました。");
		return "redirect:/";
	}
	
	//編集画面の表示
	@GetMapping("/Edit/{tra_id}")
	public  String trainingEdit(@PathVariable String tra_id, Model model,
			@ModelAttribute TraForm form, BindingResult bindingResult) {
		
		model.addAttribute("form", traService.selectByIdTra(tra_id));
		return "trainingEdit";
	}
	
	//編集画面の更新処理
	@PostMapping("/Update")
	public String trainingUpdate(@Validated @ModelAttribute("form") TraForm form,
			BindingResult bindingResult, Model model,
			RedirectAttributes attributes) {
		
		//バリデーションチェック
		if(bindingResult.hasErrors()) {
			
			model.addAttribute("form", form);
			model.addAttribute("message", "入力項目に誤りがあります。メッセージを確認し、再度入力をしてください。");
			return "trainingEdit";
		}

		Tra_Manegement tra_mane = TraHelper.convertTra(form);
		traService.updateTra(tra_mane);
		attributes.addFlashAttribute("message", form.getTra_id() +  "を更新しました");
		return "redirect:/";
	}
	
	//削除処理
	@PostMapping("/delete/{tra_id}")
	public String trainingDelete(@PathVariable String tra_id, 
			TraForm form, RedirectAttributes attributes) {
		
		
		traService.deleteTra(tra_id);
		attributes.addFlashAttribute("message", form.getTra_name() + "を削除しました");
		return "redirect:/";
	}
}
