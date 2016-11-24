import exceptions.*;
import negocio.ability.Ability;
import negocio.ability.AbilityNegocios;
import negocio.attack.Attack;
import negocio.attack.HiddenMachine;
import negocio.attack.MoveNegocios;
import negocio.local.Local;
import negocio.local.LocalNegocios;
import negocio.pokemon.Pokemon;
import negocio.pokemon.PokemonNegocios;
import negocio.trainer.Trainer;
import negocio.trainer.TrainerNegocios;
import tipo.Tipos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fachada.Fachada;

import java.util.Scanner;

/**
 * Created by "all" on 23/11/16.
 */
public class Programa {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Fachada fachada = new Fachada();

        System.out.println("Bem vindo ao PC/Pokedex do Professor Caralho.\nMe diga seu nome e a quantidade de insignias que voce já roubou, ops' já conquistou.");
        Trainer treinador = new Trainer("juca", 0);
        try {
            fachada.cadastrarTreinador(treinador);
            fachada.cadastrarTreinador(treinador);
        } catch (TrainerExistenteException | InvalidoException | TrainerBadgeInvalidoException e) {
            e.printStackTrace();
        }


    }
}
