@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    private String title;

    @Lob
    @Column(nullable = false)
    private String body;

    @ManyOne(optional = false, fetch = FetchType.LAZY)
    private User author;

    @OneMany(mappedBy = "post", targetEntity = Comment.class)
    private List<Comment> comments;

    @Column(nullable = false)
    private Date date;

    @ManyToMany
    @JoinTable
    private List<Tag> tags;

    @OneToMany(mappedBy = "postEvaluated", targetEntity = PostEvaluation.class)
    private List<PostEvaluation> evaluations;

    public Post() {
    }

    public Post(String title, String body, User author) {
        this.title = title;
        this.body = body;
        this.author = author;
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.date = new Date();

    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", title=" + title + ", body=" + body + ", author=" + author +" , date="+ date.toString()+'}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void deleteComment(Comment comment) {
        this.comments.remove(comment);
    }


    public int getPoints() {
        int points = 0;
        for (PostEvaluation postEvaluation : evaluations) {
            points += postEvaluation.getEvaluation().getValue();
        }
        return points;
    }

    public boolean hasTitle() {
        return this.title != null && !this.title.equals("");
    }
}