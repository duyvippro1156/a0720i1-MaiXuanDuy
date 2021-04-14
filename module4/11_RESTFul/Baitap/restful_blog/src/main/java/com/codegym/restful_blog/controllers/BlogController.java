package com.codegym.restful_blog.controllers;

import com.codegym.restful_blog.models.Blog;
import com.codegym.restful_blog.models.Category;
import com.codegym.restful_blog.services.BlogService;
import com.codegym.restful_blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public ResponseEntity<List<Category>> getListCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

//    @GetMapping("/")
//    public ModelAndView getList(@RequestParam(required = false) String sortDirection,
//                                @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "0") int id,
//                                @RequestParam(required = false) String s) {
//        ModelAndView modelAndView = new ModelAndView("index");
//        Page<Blog> blogPage;
//        sortDirection = sortDirection == null ? "desc" : sortDirection;
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by("createdTime").ascending() : Sort.by("createdTime").descending();
//        Pageable pageableSort = PageRequest.of(page, 3, sort);
//        if (id == 0) {
//            if (s != null) {
//                blogPage = blogService.findAllByTitleContaining(s, pageableSort);
//            } else {
//                blogPage = blogService.findAll(pageableSort);
//            }
//        } else {
//            if (s != null) {
//                blogPage = blogService.findAllByTitleContainingAndCategory_Id(s, id, pageableSort);
//            } else {
//                blogPage = blogService.findAllByCategory(id, pageableSort);
//            }
//        }
//        modelAndView.addObject("id", id);
//        modelAndView.addObject("blogs", blogPage);
//        modelAndView.addObject("sortDirection", sortDirection);
//        modelAndView.addObject("s", s);
//        return modelAndView;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

//    @GetMapping("/create")
//    public ModelAndView create() {
//        ModelAndView model = new ModelAndView("create");
//        model.addObject("blog", new Blog());
//        return model;
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> createCustomer(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
        if (blog.getId() == 0) {
            blog.setCreatedTime(LocalDate.now());
        }
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> view(@PathVariable("id") int id) {
        System.out.println("Fetching Blog with id " + id);
        Blog customer = blogService.findById(id);
        if (customer == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(customer, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteCustomer(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Blog with id " + id);

        Blog customer = blogService.findById(id);
        if (customer == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateCustomer(@PathVariable("id") int id, @RequestBody Blog blog) {
        System.out.println("Updating Blog " + id);

        Blog currentBlog = blogService.findById(id);

        if (currentBlog == null) {
            System.out.println("Blog with id " + id + " not found");
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setTitle(blog.getTitle());
        currentBlog.setContent(blog.getContent());
        currentBlog.setAuthor(blog.getAuthor());
        currentBlog.setCategory(blog.getCategory());
        currentBlog.setCreatedTime(blog.getCreatedTime());
        currentBlog.setId(blog.getId());


        blogService.save(currentBlog);
        return new ResponseEntity<Blog>(currentBlog, HttpStatus.OK);
    }
}


