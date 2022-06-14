package jp.te4a.spring.boot.myapp11;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book")
public class BookController {
	@Autowired
	BookService bookService;

	@ModelAttribute
	BookForm setUpForm() {
		return new BookForm();
	}
	@GetMapping
	String list(Model model) {
		model.addAttribute("book", bookService.findAll());
		return "book/list";
	}

	/*
		@PostMapping(path="create")
		String create(BookForm form, Model mode) {
			bookService.create(form);
			return "redirect:/book";
		}↓
	 */
	@PostMapping(path="create")
	String create(@Validated BookForm form, BindingResult result , Model model) {
		if(result.hasErrors()) {
			return list(model);
		}
		bookService.create(form);
		return "redirect:/book";
	}

	
	@PostMapping(path = "edit", params = "form")
	String editForm(@RequestParam Integer id, BookForm form) {
		BookForm bookForm = bookService.findById(id);
		//BookForm bookForm = bookService.findOne(id);
		BeanUtils.copyProperties(bookForm, form);
		return "book/edit";
	}
	 
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, @Validated BookForm form,
			BindingResult result) {
		if(result.hasErrors()) {
			//return edit(id, form);
			return editForm(id, form);
			//pdfではこれだがエラー発生　editForm関数はググっても出てこない
		}
		bookService.update(form);
		return "redirect:/book";
	}
/*
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, BookForm form) {
		bookService.update(form);
		return "redirect:/book";
	}
	*/
	
	@PostMapping(path = "delete")
	String delete(@RequestParam Integer id) {
		bookService.delete(id);
		return "redirect:/book";
	}
	@PostMapping(path = "edit", params = "goToTop")
	String goToTop() {
		return "redirect:/book";
	}
}
