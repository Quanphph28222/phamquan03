/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.CuaHang;
import Repostorities.impl.CuaHangRepostorityImpl;
import Viewmodels.CuaHangResponse;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CuaHangService {

    List<CuaHangResponse> getAll();

    String add(CuaHang CuaHang);
    
    String update(String id, CuaHang CuaHang);

    String delete(String id);
}
