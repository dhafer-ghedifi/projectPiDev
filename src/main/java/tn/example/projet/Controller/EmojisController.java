package Pi.Spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Pi.Spring.Entity.Emojis;
import Pi.Spring.Service.EmojisService;

@RestController
@RequestMapping("/Emojis")
public class EmojisController {
	@Autowired
	EmojisService emojisServ;
	
	
	@PostMapping("/add/{idPost}")
	@ResponseBody
	public void addAndAffectEmoji(@RequestBody Emojis emojis,@PathVariable ("idPost") Long idPost){
		emojisServ.addAndAffectEmojis(emojis, idPost);
		
	}
	
	@PutMapping("/update/{idEmojis}")
	@ResponseBody
	public void updateEmoji(@PathVariable ("idEmojis") Long idEmojis){
		emojisServ.updateEmojis(idEmojis);
	}

}
