public class BookService {
@Inject
private NumberGenerator numberGenerator;
  @Inject
  private EntityManager em;
  private Date instanciationDate;
  @PostConstruct
  private void initDate() {
    instanciationDate = new Date();
  }
  @Transactional
  public Book createBook(String title, Float price, String description) {
    Book book = new Book(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    book.setInstanciationDate(instanciationDate);
    em.persist(book);
    return book;
  }
}
