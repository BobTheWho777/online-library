package com.example.library.online_library.Controller;

import com.example.library.online_library.Model.Publisher;
import com.example.library.online_library.Repository.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    // Просмотр списка издателей
    @GetMapping
    public String listPublishers(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publishers/list";
    }

    // Форма добавления издателя
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/add";
    }

    // Сохранение нового издателя
    @PostMapping("/add")
    public String addPublisher(@ModelAttribute Publisher publisher) {
        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }

    // Форма редактирования издателя
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный ID издателя: " + id));
        model.addAttribute("publisher", publisher);
        return "publishers/edit";
    }

    // Сохранение изменений
    @PostMapping("/edit/{id}")
    public String editPublisher(@PathVariable Long id, @ModelAttribute Publisher publisher) {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный ID издателя: " + id));
        existingPublisher.setTitle(publisher.getTitle());
        existingPublisher.setCity(publisher.getCity());
        publisherRepository.save(existingPublisher);
        return "redirect:/publishers";
    }

    // Удаление издателя
    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный ID издателя: " + id));
        publisherRepository.delete(publisher);
        return "redirect:/publishers";
    }
}
