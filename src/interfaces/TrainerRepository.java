package interfaces;

import negocio.trainer.Trainer;

/**
 * Created by mario on 22/11/16.
 */
public interface TrainerRepository {
    public void insert(Trainer trainer);
    public boolean exist(String name);
    public Trainer search(String name);
    public void update(Trainer trainer);
    public void remove(String name);
}
