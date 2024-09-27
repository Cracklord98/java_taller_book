package com.example.demo.Controller;

import com.example.demo.Model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Define la ruta base de este controlador: todas las URLs que empiecen con "/books"
@RequestMapping("/books")
public class BookController {

    // Define que este método manejará solicitudes GET en "/books/{title}/{author}/{year}"
    @GetMapping("/{title}/{author}/{year}")
    // Método que recibe los parámetros desde la URL y los muestra en la vista
    public String getBookDetails(@PathVariable String title, @PathVariable String author, @PathVariable int year, Model model) {

        // Crea un nuevo objeto Book con los parámetros proporcionados
        Book book = new Book(title, author, year);

        // Agrega el objeto book al modelo para que pueda ser accedido desde la vista
        model.addAttribute("book",book);

        // Retorna el nombre de la vista (book.html) para mostrar los datos
        return "book";  // La vista se ubicará en src/main/resources/templates/book.html
    }
}
