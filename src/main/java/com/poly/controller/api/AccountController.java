package com.poly.controller.api;

import java.util.List;

import com.poly.model.Giay;
import com.poly.model.KhachHang;
import com.poly.service.AccountService;
import com.poly.service.LoaiGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.poly.model.LoaiGiay;


@CrossOrigin("*")
@RestController
public class AccountController {
	@Autowired
	private AccountService accountDAO;

	@GetMapping("/rest/taikhoan")
	public ResponseEntity<List<KhachHang>> getAll(Model model) {
		return ResponseEntity.ok(accountDAO.findAll());
	}

	@GetMapping("/rest/taikhoan/{id}")
	public ResponseEntity<KhachHang> getOne(@PathVariable("id") String id) {
		if (!accountDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(accountDAO.findById(id));
	}
	// Insert
	@PostMapping("/rest/taikhoan")
	public ResponseEntity<KhachHang> post(@RequestBody KhachHang khachHang) {
		if (accountDAO.existsById(khachHang.getTaiKhoan())) {
			return ResponseEntity.badRequest().build();
		}
		accountDAO.save(khachHang);
		return ResponseEntity.ok(khachHang);
	}

	// Update
	@PutMapping("/rest/taikhoan/{id}")
	public ResponseEntity<KhachHang> put(@PathVariable("id") String id, @RequestBody KhachHang khachHang) {
		if (!accountDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		accountDAO.save(khachHang);
		return ResponseEntity.ok(khachHang);
	}

	@DeleteMapping("/rest/taikhoan/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		if (!accountDAO.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		accountDAO.deleteById(id);;
		return ResponseEntity.ok().build();
	}
}
