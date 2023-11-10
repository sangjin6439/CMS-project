package skhu.campingmanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import skhu.campingmanagementsystem.dto.ItemDto;
import skhu.campingmanagementsystem.service.ItemService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/item")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public String save(@RequestBody ItemDto itemDto){
        return itemService.saveItem(itemDto);
    }

    @GetMapping("/{id}")
    public ItemDto find(@PathVariable Long id){
        return itemService.findUserByIdAs(id);
    }

    @PatchMapping
    public String update(@RequestBody ItemDto itemDto){
        return itemService.update(itemDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return itemService.delete(id);
    }
}
