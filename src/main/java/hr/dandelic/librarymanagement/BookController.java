package hr.dandelic.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping(path = "/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "/remove")
    public String removeBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "remove_book";
    }

    @PostMapping(path = "/remove")
    public String removeABook(@ModelAttribute Book book, Model model) {
        try {
            if((book = findABook(book.getName())) != null) bookRepository.delete(book);
        } catch (Exception e) {
            model.addAttribute("result", 'F');
        }
        return "index_books";
    }

    @GetMapping(path = "/add")
    public String addABookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping(path = "/add")
    public String addABook(@ModelAttribute Book book, Model model) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            model.addAttribute("result", 'F');
        }
        return "add_book";
    }

    @GetMapping(path = "index_books")
    public String indexBooks(Model model){
        model.addAttribute("bookList", getAllBooks());
        return "index_books";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findABook(String match) {
        Iterable<Book> bookIterable = bookRepository.findAll();
        while(bookIterable.iterator().hasNext()){
            Book next;
            if((next = bookIterable.iterator().next()).getName().equalsIgnoreCase(match)){
                return next;
            }
        }
        return null;
    }

}
