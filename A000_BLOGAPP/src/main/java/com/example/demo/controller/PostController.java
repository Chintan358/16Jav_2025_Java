package com.example.demo.controller;


import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.payload.APIResponse;
import com.example.demo.payload.PostDto;
import com.example.demo.service.ImageService;
import com.example.demo.service.PostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	ImageService imageService;
	
	@Value("${project.image}")
	String path;
	
	@PostMapping("/user/{uid}/category/{catid}")
	public ResponseEntity<PostDto> addPost(@Valid 
						@RequestBody PostDto postdto,
						@PathVariable("uid") int uid,
						@PathVariable("catid") int cid)
	{
	
		PostDto createdPost = postService
						.addPost(postdto, cid, uid);
		
		return new ResponseEntity<>(createdPost,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<PostDto>> allPosts(
			@RequestParam(value ="pageNumber", defaultValue ="1") int pageNumber,
			@RequestParam(value="pageSize", defaultValue ="1") int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
			@RequestParam(value = "sortType", defaultValue = "asc") String sortType
			)
	{
		List<PostDto> posts =  postService.allPost(pageNumber,pageSize,sortBy,sortType);
		return new ResponseEntity<>(posts,HttpStatus.OK );
	}
	
	@PutMapping("{pid}/user/{uid}/category/{catid}")
	public ResponseEntity<PostDto> addPost(@Valid 
						@RequestBody PostDto postdto,
						@PathVariable("uid") int uid,
						@PathVariable("catid") int cid,
						@PathVariable("pid") int pid)
					
	{
	
		PostDto updatedPost = postService
						.postUpdate(postdto,pid, cid, uid);
		
		return new ResponseEntity<>(updatedPost,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/{pid}")
	public ResponseEntity<PostDto> postById(@PathVariable("pid") int pid)
	{
		PostDto dto = postService.postById(pid);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<APIResponse> deletePost(@PathVariable("pid") int pid)
	{
		postService.deletePost(pid);
		return new ResponseEntity<>(new APIResponse("Post deleted","true"),HttpStatus.OK);
	}
	
	
	@GetMapping("/category/{cid}")
	public ResponseEntity<List<PostDto>> postbycategory(@PathVariable("cid") int cid)
	{
		List<PostDto> allposts = postService.postsbyCategory(cid);
		return new ResponseEntity<>(allposts,HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<List<PostDto>> postbyuser(@PathVariable("uid") int uid)
	{
		List<PostDto> allposts = postService.postsByUsers(uid);
		return new ResponseEntity<>(allposts,HttpStatus.OK);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPost(@PathVariable("keyword") String keyword)
	{
		List<PostDto> allpost = postService.searchPost(keyword);
		return new ResponseEntity<>(allpost,HttpStatus.OK);
	}
	
	@PostMapping("/upload/{postid}")
	public ResponseEntity<PostDto> uploadImage(@PathVariable("postid") int postid,
							@RequestParam("image") MultipartFile file)
	{
		PostDto postdto = postService.postById(postid);
		String img =  imageService.uploadImage(path, file);
		postdto.setImage(img);
		
		PostDto createdImage =  postService.addImage(postdto);
		return new ResponseEntity<>(createdImage,HttpStatus.CREATED);
	}
	
	@GetMapping(produces =MediaType.IMAGE_JPEG_VALUE,value = "/image/{imagename}")
	public ResponseEntity<Resource> viewImage(@PathVariable("imagename") String imgname, HttpServletResponse resp)
	{
		InputStream is = imageService.getImage(path, imgname);
		//resp.setContentType(MediaType.IMAGE_JPEG_VALUE);
		Resource resource = new InputStreamResource(is);
		return ResponseEntity.ok()
	                .contentType(MediaType.IMAGE_JPEG)
	                .body(resource);
	}
	
}
