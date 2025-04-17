package ma.emsi.mvcspring.web;
import ma.emsi.mvcspring.entities.Product;
import ma.emsi.mvcspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository ;
    @GetMapping("/index")
    public String index(Model model){
        List< Product> products = productRepository.findAll();
        model.addAttribute("listProducts",products);
        return "products";}
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
        productRepository.deleteById(id);
        return "redirect:/index";
    }
}
