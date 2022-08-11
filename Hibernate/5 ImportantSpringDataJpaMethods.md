# Spring Data JPA Repository Methods

<img width="1368" alt="Screenshot 2022-08-09 at 10 17 21 PM" src="https://user-images.githubusercontent.com/30944903/183710186-24e4b468-8442-463d-b3c7-d994c2d61e36.png">


<img width="773" alt="Screenshot 2022-08-10 at 10 08 35 AM" src="https://user-images.githubusercontent.com/30944903/183817211-17ab1559-6189-4f0a-b5cb-8e70f15e57d9.png">

# 1 save()  - Save an entity to database table

```java
@Test
  void saveMethod(){
    // create product
    Product product = new Product();
    product.setName("product 1");
    product.setDescription("product 1 description");
    product.setSku("100ABC");
    product.setPrice(new BigDecimal(100));
    product.setActive(true);
    product.setImageURL("product1.png");

    // save product
    Product savedObject = productRepository.save(product);

    // display product info
    System.out.println(savedObject.getId());
    System.out.println(savedObject.toString());

  }
```

# 2 save()  - Update an entity to database table

```java
  @Test
  void updateUsingSaveMethod(){

    // find or retrieve an entity by id
    Long id = 1L;
    Product product = productRepository.findById(id).get();

    // update entity information
    product.setName("updated product 1");
    product.setDescription("updated product 1 desc");

    // save updated entity
    productRepository.save(product);
  }
```

# 3 findById()  - Retrive a single entity from database table

```java
@Test
  void findByIdMethod(){
    Long id = 1L;

    Product product = productRepository.findById(id).get();
  }

```

# 4 saveAll() - save multiple entries into the database table

```java
  @Test
  void saveAllMethod(){

    // create product
    Product product = new Product();
    product.setName("product 2");
    product.setDescription("product 2 description");
    product.setSku("100ABCD");
    product.setPrice(new BigDecimal(200));
    product.setActive(true);
    product.setImageURL("product2.png");

    // create product
    Product product3 = new Product();
    product3.setName("product 3");
    product3.setDescription("product 3 description");
    product3.setSku("100ABCDE");
    product3.setPrice(new BigDecimal(300));
    product3.setActive(true);
    product.setImageURL("product3.png");

    productRepository.saveAll(List.of(product, product3));

  }
```

# 5 findAll()  - retrive all entity from database table

```java
  @Test
  void findAllMethod(){

    List<Product> products = productRepository.findAll();

    products.forEach((p) -> {
      System.out.println(p.getName());
    });

  }

```

# 6 deleteById()  - delete a single entity by id from database table

```java
@Test
  void deleteByIdMethod() {
    Long id = 1L;
    productRepository.deleteById(id);
  }
```

# 7 delete()  - delete an entity from database table

```java
  @Test
  void deleteMethod(){

    // find an entity by id
    Long id = 2L;
    Product product = productRepository.findById(id).get();

    // delete(entity)
    productRepository.delete(product);

  }
```


# 8 deleteAll()  - delete all entity from database table

```java
 @Test
  void deleteAllMethod(){

    // productRepository.deleteAll();

    Product product = productRepository.findById(5L).get();

    Product product1 = productRepository.findById(6L).get();

    productRepository.deleteAll(List.of(product, product1));

  }
```

# 9 count()  - retrive the number of entity from database table

```java
  @Test
  void countMethod(){
    long count = productRepository.count();
    System.out.println(count);
  }
```

# 10 existById()  - check if enity of given id exist in db
```java

  @Test
  void existsByIdMethod(){
    Long id = 7L;

    boolean result = productRepository.existsById(id);

    System.out.println(result);
  }
```


