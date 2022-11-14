/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Services.impl.*;
import DomainModels.CTSanPham;
import Viewmodels.CTSanPhamReposton;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CTSanPhamService {

    List<CTSanPhamReposton> getAll();

    CTSanPham getOne(String id);

    String add(CTSanPham ctsp);

    String update(String id, CTSanPham ctsp);

    String delete(String id);
}
