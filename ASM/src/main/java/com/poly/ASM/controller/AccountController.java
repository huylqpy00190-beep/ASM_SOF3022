package com.poly.ASM.controller;

import com.poly.ASM.Service.AccountService;
import com.poly.ASM.Service.MailService;
import com.poly.ASM.entity.Account;
import com.poly.ASM.utils.MailUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    HttpSession session;

    @Autowired
    AccountService accountService;

    @Autowired
    MailService mailService;

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("view", "account/sign-up");
        return "layout/layout";
    }

    @PostMapping("/sign-up")
    public String signUp(Account account, Model model) {
        try {
            account.setActivated(false);
            accountService.create(account);

            // Gửi mail kích hoạt
            mailService.send(account.getEmail(), "Kích hoạt tài khoản",
                    MailUtils.activationContent(account.getUsername()));

            return "redirect:/auth/login?message=SignupSuccess";
        } catch (Exception e) {
            e.printStackTrace();
            // Thông báo cho người dùng biết đăng ký thành công nhưng gửi mail lỗi
            return "redirect:/auth/login?error=MailServiceError";
        }
    }

    @GetMapping("/edit-profile")
    public String editProfile(Model model) {
        model.addAttribute("view", "account/edit-profile");
        return "layout/layout";
    }

    @PostMapping("/edit-profile")
    public String updateProfile(@RequestParam("fullname") String fullname,
                                @RequestParam("photo_file") org.springframework.web.multipart.MultipartFile file) {
        Account user = (Account) session.getAttribute("user");

        // Chỉ cập nhật họ tên
        user.setFullname(fullname);

        // Xử lý upload file ảnh nếu người dùng có chọn file
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            // Lưu file vào thư mục thực tế (Ví dụ: src/main/resources/static/images/users)
            // user.setPhoto(fileName);
        }

        accountService.update(user); // Giả sử service của bạn có hàm update
        session.setAttribute("user", user); // Cập nhật lại thông tin trong Session

        return "redirect:/account/edit-profile";
    }

    @GetMapping("/forgot-password")
    public String forgot(Model model) {
        model.addAttribute("view", "account/forgot-password");
        return "layout/layout";
    }
    @PostMapping("/forgot-password")
    public String processForgot(@RequestParam("email") String email, Model model) {
        try {
            Account user = accountService.findByEmail(email);
            if (user == null) {
                model.addAttribute("error", "Email này không tồn tại trong hệ thống!");
            } else {
                String newPassword = Long.toHexString(System.currentTimeMillis()).substring(0, 6);
                user.setPassword(newPassword);
                accountService.update(user);

                String content = MailUtils.forgotPasswordContent(newPassword);
                mailService.send(user.getEmail(), "Cấp lại mật khẩu", content);

                model.addAttribute("message", "Mật khẩu mới đã được gửi tới " + user.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Hiển thị lỗi cụ thể để bạn dễ debug
            model.addAttribute("error", "Lỗi hệ thống: Gmail server từ chối kết nối. Vui lòng kiểm tra App Password!");
        }
        model.addAttribute("view", "account/forgot-password");
        return "layout/layout";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model) {
        model.addAttribute("view", "account/change-password");
        return "layout/layout";
    }

    @PostMapping("/change-password")
    public String processChangePassword(@RequestParam("oldPassword") String oldPassword,
                                        @RequestParam("newPassword") String newPassword,
                                        @RequestParam("confirmPassword") String confirmPassword,
                                        Model model) {
        Account user = (Account) session.getAttribute("user");

        // 1. Kiểm tra mật khẩu cũ
        if (!user.getPassword().equals(oldPassword)) {
            model.addAttribute("error", "Mật khẩu cũ không chính xác!");
        }
        // 2. Kiểm tra mật khẩu mới và xác nhận mật khẩu
        else if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "Xác nhận mật khẩu không khớp!");
        }
        // 3. Nếu mọi thứ đều đúng
        else {
            user.setPassword(newPassword);
            accountService.update(user);
            session.setAttribute("user", user); // Cập nhật session
            model.addAttribute("message", "Bạn đã đổi mật khẩu thành công!");
        }

        model.addAttribute("view", "account/change-password");
        return "layout/layout";
    }
}
