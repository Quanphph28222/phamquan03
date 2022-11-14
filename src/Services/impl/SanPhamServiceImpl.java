/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.impl;

import DomainModels.sanPham;
import Repostorities.SanPhamRepository;
import Repostorities.impl.SanPhamRepositoryImpl;
import Services.SanPhamService;
import java.util.List;

/**
 *
 * @author pc
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepo = new SanPhamRepositoryImpl();

    @Override
    public List<sanPham> getAll() {
        return sanPhamRepo.getAll();
    }

    @Override
    public String addSanPham(sanPham sp) {
        boolean addsp = sanPhamRepo.addSanPham(sp);
        if (addsp) {
            return "Thêm sản phẩm thành công";
        }
        return "Thêm sản phẩm thất bại";
    }

    @Override
    public String updateSanPham(String id, sanPham sp) {
        boolean updatesp = sanPhamRepo.updateSanPham(id, sp);
        if (updatesp) {
            return "Sửa sản phẩm thành công";

        }
        return "Sửa sản phẩm thất bại";
    }

    @Override
    public String deleteSanPham(String id) {
        boolean deletesp = sanPhamRepo.deleteSanPham(id);
        if (deletesp) {
            return "Xóa sản phẩm thành công";

        }
        return "Xóa sản phẩm thất bại";
    }

}
