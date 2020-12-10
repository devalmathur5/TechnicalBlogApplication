package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

//    @PersistenceUnit(unitName = "techicalblog")
//    private EntityManagerFactory emf;
    @Autowired
    private PostRepository pr;
    
    public List<Post> getAllPosts() {
        return pr.getAllPosts();
    }

    public Post getOnePost(){

        System.out.println("post service : "+pr.getLatestPost());

        return pr.getLatestPost();
    }

    public void createPost (Post newPost){
        newPost.setDate(new Date());
        pr.createPost(newPost);
        System.out.println("new post "+ newPost);
    }

    public Post getPost(Integer postId) {
        return pr.getPost(postId);
    }

    public void updatePost(Post updatedPost){
        updatedPost.setDate(new Date());
        pr.updatePost(updatedPost);
    }

    public void deletePost(Integer postId){
        pr.deletePost(postId);
    }
}

//--------------------------- JDBC-----------------------------

//        ArrayList<Post> posts = new ArrayList<>();
//        Connection connection = null;
//        try{
//            Class.forName("org.postgresql.Driver");
//
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/technicalblog","postgres", "postgres");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posts");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("body"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            connection.close();
//        }
//        return result;