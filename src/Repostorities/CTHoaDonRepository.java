/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repostorities;

import DomainModels.CTHoaDon;
import java.util.List;

/**
 *
 * @author pc
 */
public interface CTHoaDonRepository {

    List<CTHoaDon> getAll();

    boolean addHoaDon(CTHoaDon cthd);

    boolean updateHoaDon(String id, CTHoaDon cthd);

    boolean deleteHoaDon(String id);
}
