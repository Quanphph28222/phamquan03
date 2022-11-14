/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DomainModels.CTHoaDon;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CTHoaDonService {

    List<CTHoaDon> getAll();

    String addHoaDon(CTHoaDon cthd);

    String updateHoaDon(String id, CTHoaDon cthd);

    String delete(String id);
}
