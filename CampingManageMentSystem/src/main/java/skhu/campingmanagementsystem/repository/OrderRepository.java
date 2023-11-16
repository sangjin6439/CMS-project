package skhu.campingmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skhu.campingmanagementsystem.domain.Order;
import skhu.campingmanagementsystem.domain.User;
import skhu.campingmanagementsystem.dto.OrderDto;
import skhu.campingmanagementsystem.dto.UserDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
