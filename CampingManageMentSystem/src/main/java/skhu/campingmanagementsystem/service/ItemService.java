package skhu.campingmanagementsystem.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import skhu.campingmanagementsystem.domain.Item;
import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.repository.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public String saveItem(ItemDto itemDto){
        Item item = save(itemDto);
        itemRepository.save(item);
        return "저장 성공!";
    }

    //상품 생성 매서드
    private Item save(ItemDto itemDto){
        return Item.builder()
                .name(itemDto.getName())
                .price(itemDto.getPrice())
                .orderDetails(itemDto.getOrderDetails())
                .build();
    }

    //아이디로 조회
    @Transactional(readOnly = true)
    public ItemDto findUserByIdAs(Long itemId){
        ItemDto itemDto = findUserById(itemId).toDto();
        return itemDto;
    }

    private Item findUserById(Long itemId){
        return itemRepository.findItemById(itemId).orElseThrow(()->new IllegalArgumentException("정확한 정보를 입력해주세요"));
    }

    //정보 수정
    @Transactional
    public String update(ItemDto itemDto){
        updateItem(itemDto);
        return "수정 성공";
    }

    //수정 메서드
    private void updateItem(ItemDto itemDto){
        findUserById(itemDto.getId()).update(itemDto);
    }

    public String delete(Long itemId){
        Item item = findUserById(itemId);
        itemRepository.delete(item);
        return "삭제 완료";
    }
}
