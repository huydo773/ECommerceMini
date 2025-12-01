# E-Commerce Mini

**Technology Stack:** Spring Boot, Spring Data JPA, Hibernate, MySQL, Spring Security, Thymeleaf / REST API, Git/GitHub

---

## Project Overview

E-Commerce Mini là một ứng dụng thương mại điện tử đơn giản nhưng chuyên nghiệp, mô phỏng hệ thống marketplace với nhiều loại người dùng: **Admin, Seller, Customer**. Dự án cung cấp các chức năng cơ bản của một hệ thống bán hàng online, từ quản lý người dùng, sản phẩm, đơn hàng, giỏ hàng đến quyền hạn người dùng.

---

## Key Features

- **User Management:** Admin quản lý người dùng, phân quyền; người dùng đăng ký, đăng nhập, cập nhật thông tin cá nhân.
- **Role-based Access Control (RBAC):**
    - Admin: quản lý user, giám sát hệ thống
    - Seller: quản lý sản phẩm của mình, xem đơn hàng liên quan
    - Customer: mua sản phẩm, quản lý giỏ hàng, theo dõi đơn hàng
- **Product & Category Management:** Quản lý danh mục và sản phẩm với thông tin tên, mô tả, giá, số lượng, hình ảnh.
- **Shopping Cart & Orders:** Customer thêm sản phẩm vào giỏ hàng, tạo đơn hàng, quản lý trạng thái PENDING, PAID, SHIPPED.
- **Voucher / Discount (Optional):** Hỗ trợ mã giảm giá cho đơn hàng.
- **Secure Authentication & Authorization:** Spring Security + JWT/session, hash password, phân quyền theo role.
- **Database & Persistence:** Spring Data JPA + MySQL, quan hệ entity rõ ràng (User, Role, Product, Category, Order, OrderItem, Cart).

---

## Technical Highlights

- **Spring Boot** cho backend, RESTful API hoặc Thymeleaf cho frontend.
- **DTO pattern** để tách entity và dữ liệu trả về client.
- **RBAC** giúp phân quyền rõ ràng, dễ mở rộng.
- **Git/GitHub** để quản lý phiên bản, commit rõ ràng và push dự án hoàn chỉnh.

---

## Project Goals

- Thực hành thiết kế hệ thống bán hàng online chuyên nghiệp.
- Hiểu mô hình dữ liệu (ERD) và quan hệ giữa các entity.
- Thực hành phân quyền người dùng và bảo mật.
- Xây dựng project chuẩn để đưa vào **portfolio/CV**.

---

## License

This project is open-source and available for learning purposes.