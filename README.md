Book APIs:
POST /api/books,
GET /api/books,
GET /api/books/{id},
DELETE /api/books/{id

Member APIs:
POST /api/members,
GET /api/members,
GET /api/members/{id},
DELETE /api/members/{id}

Borrow APIs:
POST /api/borrow/borrow,
POST /api/borrow/return

Controller Layer handles HTTP requests. Uses @RestController. Validates input using @Valid. Returns ResponseEntity
Service Layer Business logic handles borrowing rules. Uses logging (@Slf4j)
DAO Layer extends JpaRepository. No implementation needed (Spring auto-generates)
DTO used to validate input. Prevents exposing entity directly
Model (Entity) represents database tables. Uses @Entity, @Id, @ManyToOne
Logging using Lombok: @Slf4j
log.info("message");
