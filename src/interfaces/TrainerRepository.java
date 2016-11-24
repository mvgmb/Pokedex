package interfaces;

import negocio.trainer.Trainer;

/**
 * Created by mario on 22/11/16.
 */
public interface TrainerRepository {
    void insert(Trainer trainer);
    boolean exist(String name);
    Trainer search(String name);
    void update(Trainer trainer);
    void remove(String name);
    Trainer[] returnContent();
}
