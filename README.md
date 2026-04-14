# 449 Assignment2 - Kevin Chau

## Requirements Screenshots

### 1. DELETE Endpoint (`BookController.java`)
Add a DELETE endpoint to your existing BookController that deletes a book by its ID. The endpoint should be:
`DELETE /api/books/{id}`

**Admin Delete 200 Success:**
<img width="1485" height="937" alt="deletebookadmin" src="https://github.com/user-attachments/assets/678de01d-3b5b-4bb0-80f1-666658439a73" />
**Admin Delete 404 Book ID Not Found:**
<img width="1474" height="695" alt="notfound" src="https://github.com/user-attachments/assets/51f62f18-1899-4388-9e5e-ec72338575ef" />

---

### 2. Security Configuration (`SecurityConfig.java`)
**Protected the DELETE endpoint so only users with the ADMIN role can access it.**

### 3. Register ADMIN User
Using Postman, register a new user with both USER and ADMIN roles using the /api/auth/register endpoint:

**Register Admin:**
<img width="1537" height="939" alt="createADMIN" src="https://github.com/user-attachments/assets/51930299-0e0e-4bcb-83d9-c55420c8d22d" />
**Register User:**
<img width="1494" height="898" alt="userOneReigsete" src="https://github.com/user-attachments/assets/7afdb48b-8469-49a4-8ddc-ffd8151da1f5" />

---

### 4. Test Scenario 1 — ADMIN can delete (must pass)
**Log in as the admin user, copy the JWT token, and make a DELETE request to /api/books/{id} with the token in the Authorization header. The book should be deleted successfully and return 200 OK.**

**Step 1: Login as Admin:**
<img width="1539" height="948" alt="loginADMIN" src="https://github.com/user-attachments/assets/c7b4f0a3-6446-40fb-aaa7-5a8a494d39ea" />
**Step 2: Make A Delete Request to /api/books/{id} with the Authorization token:**
<img width="1485" height="937" alt="deletebookadmin" src="https://github.com/user-attachments/assets/75dc042a-fe61-4961-80fc-ff36dad5fb80" />
**Returned 200 OK Success.**

---

###5. Test Scenario 2 — USER cannot delete (must pass)
**Register a second user with only the USER role. Log in as that user, copy the JWT token, and make a DELETE request to /api/books/{id} with that token. The response must be 403 Forbidden — not 401 Unauthorized. Include the proper Spring Security exception message in the response body.**

**Step 1: Login as User:**
<img width="1491" height="909" alt="userOneLogin" src="https://github.com/user-attachments/assets/327308b0-0243-449e-9ad5-2ea0489c7865" />
**Step 2: Make A Delete Request to /api/books/{id} with the Authorization token:**
<img width="1473" height="937" alt="accessDenied" src="https://github.com/user-attachments/assets/49f6e770-faaf-42cc-a7e0-8da834586caf" />
**Returned 403 Forbidden, Access Denied text in JSON.**



