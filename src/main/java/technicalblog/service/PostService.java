package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.util.ArrayList;
import java.util.Date;

@Service
public class PostService {

    public PostService(){
        System.out.println("PostService");
    }

    public ArrayList<Post> getAllPosts(){

        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setBody("body 1");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("body 2");
        post2.setDate(new Date());

        Post post3 = new Post();
        post3.setTitle("Post 3");
        post3.setBody("body 3");
        post3.setDate(new Date());

        posts.add(post1);
        posts.add(post2);
        posts.add(post3);

        return posts;
    }


    public ArrayList<Post> getOnePost(){
        ArrayList<Post> post = new ArrayList<>();

        Post postOne = new Post();
        postOne.setTitle("This is one Post");
        postOne.setBody("This post is a valid one");
        postOne.setDate(new Date());

        post.add(postOne);
        return post;
    }
}
