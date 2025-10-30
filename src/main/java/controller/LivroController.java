package com.biblioteca.meuslivros.controller;

import com.biblioteca.meuslivros.model.Livro;
import com.biblioteca.meuslivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/livros") // Prefixo para todas as rotas deste controller
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    /**
     * PÁGINA LISTAR (Read)
     * Mapeia a rota GET /livros
     */
    @GetMapping
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/list"; // -> /templates/livros/list.html
    }

    /**
     * PÁGINA VISUALIZAR (Read)
     * Mapeia a rota GET /livros/{id}
     */
    @GetMapping("/{id}")
    public String visualizarLivro(@PathVariable("id") Long id, Model model) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isEmpty()) {
            return "redirect:/livros";
        }
        model.addAttribute("livro", livroOpt.get());
        return "livros/view"; // -> /templates/livros/view.html
    }

    /**
     * PÁGINA CADASTRAR (Create) - Formulário
     * Mapeia a rota GET /livros/novo
     */
    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("pageTitle", "Cadastrar Novo Livro");
        return "livros/form"; // -> /templates/livros/form.html
    }

    /**
     * PÁGINA CADASTRAR (Create) - Ação
     * Mapeia a rota POST /livros/salvar
     */
    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    /**
     * PÁGINA EDITAR (Update) - Formulário
     * Mapeia a rota GET /livros/editar/{id}
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable("id") Long id, Model model) {
        Optional<Livro> livroOpt = livroRepository.findById(id);
        if (livroOpt.isEmpty()) {
            return "redirect:/livros";
        }
        model.addAttribute("livro", livroOpt.get());
        model.addAttribute("pageTitle", "Editar Livro");
        return "livros/form"; // Reutiliza o mesmo formulário de cadastro
    }
    // A ação de salvar da edição usará o mesmo POST /livros/salvar,
    // pois o Spring/JPA identifica pelo ID se deve criar (INSERT) ou atualizar (UPDATE).

    /**
     * AÇÃO DE EXCLUIR (Delete)
     * Mapeia a rota GET /livros/excluir/{id}
     */
    @GetMapping("/excluir/{id}")
    public String excluirLivro(@PathVariable("id") Long id) {
        livroRepository.deleteById(id);
        return "redirect:/livros";
    }
}