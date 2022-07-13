package test.memoryDB.repository;

import test.memoryDB.domain.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryDbRepository implements DBRepository{

    private final List<Entity> store = new ArrayList<>();
    private Long index = 0L;

    @Override
    public Entity save(Entity entity) {
        var optionalEntity = store.stream()
                .filter(e -> e.getIndex().equals(entity.getIndex()))
                .findFirst();

        // data가 이미 존재하는 경우
        if(optionalEntity.isPresent()) {  // 옵션 엔티티의 값이 null 이 아니라면 -> 값이 존재함
            Long preIndex = optionalEntity.get().getIndex(); // Optional의 값을 열고, store에 있던 Entity 객체의 인덱스를 불러옴
            entity.setIndex(preIndex);  // 새로운 Entity에 기존 인덱스값 저장
            deleteById(preIndex); // 기존 store의 인덱스 값 삭제
        } else {
            index++;
            entity.setIndex(this.index);
        }
        store.add(entity);
        return entity;
    }

    @Override
    public Optional<Entity> findById(Long index) {
        return store.stream()
                .filter(e -> e.getIndex().equals(index))
                .findFirst();
    }

    @Override
    public void deleteById(Long index) {
        var optionalEntity = store.stream()
                .filter(e -> e.getIndex().equals(index))
                .findFirst();
        optionalEntity.ifPresent(store::remove);
    }

    @Override
    public List<Entity> findAll() {
        return store;
    }
}
