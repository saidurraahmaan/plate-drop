package com.s4r.persistence.menuitem;

import com.s4r.domain.menuitem.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {


}
