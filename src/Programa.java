import abstracts.Move;
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
public class Programa
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Fachada fachada = new Fachada();

        System.out.println("Bem vindo ao PC/Pokedex do Professor Caralho.\nMe diga seu nome e a quantidade de insignias que voce já conquistou.");
        boolean exito = true;
        do {
            Trainer treinador = new Trainer(in.nextLine(), in.nextInt());
            exito = true;
            try {
                fachada.cadastrarTreinador(treinador);
            } catch (InvalidoException e) {
                System.out.println("Digite um treinador.");
                exito = false;
            } catch (TrainerExistenteException e){
                System.out.println("Treinador já existe, digite novamente.");
                exito = false;
            } catch (TrainerBadgeInvalidoException e){
                System.out.println("Número de insígnias inválido, digite novamente.");
                exito = false;
            }
        } while (!exito);
        in.nextLine();

        boolean succesAll = true;

        do {
            succesAll = true;
            System.out.println("O que você quer fazer ?\nDigite 1 para Adcionar Pokemon\nDigite 2 para remover Pokemon\nDigite 3 para Procurar Pokemon\nDigite 4 para Atualizar Pokemon\nDigite 5 para Adcionar Habilidade\nDigite 6 para Remover Habilidade\nDigite 7 para Procurar Habilidade\nDigite 8 para Atualizar Habilidade\nDigite 9 para Adcionar Local\nDigite 10 para Remover Local\nDigite 11 para Procurar Local\nDigite 12 para Atualizar Local\nDigite 13 para Adcionar HiddenMachine\nDigite 14 para Remover HiddenMachinete\nDigite 15 para Procurar HiddenMachine\nDigite 16 para Atualizar HiddenMachine\nDigite 17 para Adcionar Ataque\nDigite 18 para Remover Ataque\nDigite 19 para Procurar Ataque\nDigite 20 para Atualizar Ataque\nDigite 0 para parar o programa");
            String aux = in.nextLine();
            boolean success = true;
            switch (aux) {
                case "1" :
                    success = true;
                    do {
                        System.out.println("Digite : numero, nome, tipo e habilidade, respectivamente.");
                        Pokemon pokemon = new Pokemon(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
                        System.out.println("Digite um ataque:");
                        pokemon.setArrayMoveID(in.nextLine());
                        System.out.println("Digite um local onde é encontrado:");
                        pokemon.setArrayLocalID(in.nextLine());
                        success = true;
                        try {
                            fachada.cadastrarPokemon(pokemon);
                        } catch (AtaqueInexistenteException | InvalidoException | PokemonNumberInexistenteException | TipoInvalidoException | PokemonIDHabilidadeInexistenteException | PokemonExistenteException | PokemonNumberInvalidoException | LocalInexistenteException e) {
                            System.out.println("Digite novamente.");
                            System.out.println("Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "2" :
                    success = true;
                    do {
                        System.out.println("Digite o nome do Pokemon");
                        success = true;
                        try {
                            fachada.removerPokemon(in.nextLine());
                        } catch (PokemonInexistenteException | InvalidoException e) {
                            System.out.println("Digite novamente");
                            System.out.println("Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "3" :
                    success = true;
                    do {
                        System.out.println("Digite o nome do Pokemon");
                        success = true;
                        try {
                            fachada.procurarPokemon(in.nextLine());
                        } catch (PokemonInexistenteException | InvalidoException e) {
                            System.out.println("Erro na procura. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;
                case "4" :
                    success = true;
                    do {
                        System.out.println("Digite o nome do Pokemon");
                        success = true;
                        try {
                            Pokemon pokemon = fachada.procurarPokemon(in.nextLine());
                            System.out.println("Digite : numero, tipo e habilidade, respectivamente.");
                            pokemon.setNumber(in.nextLine());
                            pokemon.setType(in.nextLine());
                            pokemon.setAbilityID(in.nextLine());
                            System.out.println("Digite um ataque:");
                            pokemon.setArrayMoveID(in.nextLine());
                            System.out.println("Digite um local onde é encontrado:");
                            pokemon.setArrayLocalID(in.nextLine());
                            fachada.atualizarPokemon(pokemon);
                        } catch (PokemonInexistenteException | InvalidoException e) {
                            System.out.println("Digite novamente o nome do pokemon");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        } catch (PokemonNumberInvalidoException | TipoInvalidoException | PokemonNumberInexistenteException | PokemonExistenteException | LocalInexistenteException | AtaqueInexistenteException | PokemonIDHabilidadeInexistenteException e) {
                            System.out.println("Erro na modificação do pokemon. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "5" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Habilidade e sua descrição, respectivamente, cada um em sua linha.");
                        success = true;
                        Ability habilidade = new Ability(in.nextLine(), in.nextLine());
                        try {
                            fachada.cadastrarHabilidade(habilidade);
                        } catch (HabilidadeDescricaoInexistenteException | HabilidadeExistenteException | InvalidoException e) {
                            System.out.println("Erro no cadastro da Habilidade. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;
                case "6" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Habilidade");
                        success = true;
                        try {
                            fachada.removerPokemon(in.nextLine());
                        } catch (PokemonInexistenteException | InvalidoException e) {
                            System.out.println("Erro na remoção da Habilidade. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "7" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Habilidade");
                        success = true;
                        try {
                            fachada.procurarPokemon(in.nextLine());
                        } catch (PokemonInexistenteException | InvalidoException e) {
                            System.out.println("Erro na procura da Habilidade. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "8" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Habilidade");
                        try {
                            Ability habilidade = fachada.procurarHabilidade(in.nextLine());
                            System.out.println("Digite a nova descrição");
                            habilidade.setDescription(in.nextLine());
                            fachada.atualizarHabilidade(habilidade);
                        } catch (HabilidadeInexistenteException | InvalidoException | HabilidadeDescricaoInexistenteException e) {
                            System.out.println("Erro na atualização da Habilidade. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "9" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Região, Cidade e Rota, respectivamente, cada um em sua linha");
                        success = true;
                        Local local = new Local(in.nextLine(), in.nextLine(), in.nextLine());
                        try {
                            fachada.cadastrarLocal(local);
                        } catch (InvalidoException | LocalCidadeInvalidaException | LocalInexistenteException | LocalExistenteException | LocalRotaInvalidaException e) {
                            System.out.println("Erro no cadastramento do Local. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "10" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Região");
                        success = true;
                        try {
                            fachada.removerLocal(in.nextLine());
                        } catch (LocalInexistenteException | InvalidoException e) {
                            System.out.println("Erro na remoção da região. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "11" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Região");
                        success = true;
                        try {
                            fachada.procurarLocal(in.nextLine());
                        } catch (LocalInexistenteException | InvalidoException e) {
                            System.out.println("Erro na procura da região. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;

                case "12" :
                    success = true;
                    do {
                        System.out.println("Digite o nome da Região");
                        try {
                            Local local = fachada.procurarLocal(in.nextLine());
                            System.out.println("Digite a nova Cidade e Rota, respectivamente, cada um em sua linha");
                            local.setCity(in.nextLine());
                            local.setRoute(in.nextLine());
                            fachada.atualizarLocal(local);
                        } catch (LocalCidadeInvalidaException | InvalidoException | LocalInexistenteException | LocalRotaInvalidaException e) {
                            System.out.println("Erro na atualização da região. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while (!success);
                    break;
                case "13" :
                success = true;
                do{
                    System.out.println("Digite o nome do hm, o tipo, quantidade de pp, \n o efeito fora da batalha e dentro da batalha, \n respectivamente, em sua própria linha:");
                    Move move = new HiddenMachine(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
                    try {
                        fachada.cadastrarHiddenMachine((HiddenMachine) move);
                        System.out.println("Sucesso na operação");
                    } catch (HiddenMachineEfeitoExteriorInvalidoException | InvalidoException | TipoInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineExistenteException | HiddenMachinePPException e) {
                        System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                        int loop = in.nextInt();
                        if (loop == 1)
                            success = false;
                    }
                } while(!success);
                break;

                case "14" :
                success = true;
                do{
                    System.out.println("Digite o nome do hm a ser removido:");
                    try {
                        fachada.removerHiddenMachine(in.nextLine());
                        System.out.println("Sucesso na operação");
                    } catch (HiddenMachineInexistenteException | InvalidoException e) {
                        System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                        int loop = in.nextInt();
                        if (loop == 1)
                            success = false;
                    }
                } while(!success);
                break;

                case "15" :
                success = true;
                do{
                    System.out.println("Digite o nome do HM a ser buscado:");
                    try {
                        fachada.procurarHiddenMachine(in.nextLine());
                        System.out.println("Sucesso na operação");
                    } catch (HiddenMachineInexistenteException | InvalidoException e) {
                        System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                        int loop = in.nextInt();
                        if (loop == 1)
                            success = false;
                    }
                } while(!success);
                break;

                case "16" :
                success = true;
                do{
                    System.out.println("Digite o nome do hm a ser atualizado:");
                    try {
                        HiddenMachine move = fachada.procurarHiddenMachine(in.nextLine());
                        System.out.println("Digite o tipo, quantidade de pp, \n o efeito fora da batalha e dentro da batalha, \n respectivamente, em sua própria linha:");
                        move.setType(in.nextLine());
                        move.setPP(in.nextLine());
                        move.setOutEffect(in.nextLine());
                        move.setEffect(in.nextLine());
                        fachada.atualizarHiddenMachine(move);
                        System.out.println("Sucesso na operação");
                    } catch (HiddenMachineEfeitoExteriorInvalidoException | InvalidoException | TipoInvalidoException | HiddenMachineEfeitoInvalidoException | HiddenMachineInexistenteException | HiddenMachinePPException | HiddenMachineExistenteException e) {
                        System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                        int loop = in.nextInt();
                        if (loop == 1)
                            success = false;
                    }

                } while(!success);
                break;
                case "17" :
                    success = true;
                    do{
                        System.out.println("Digite o nome do ataque, o tipo, quantidade de pp,o dano , e o efeito dentro da batalha, respectivamente, em sua própria linha:");
                        Move move = new Attack(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine());
                        try {
                            fachada.cadastrarAtaque((Attack) move);
                            System.out.println("Sucesso na operação");
                        } catch (AtaqueEfeitoInvalidoException | AtaqueExistenteException | AtaquePPInvalidoException | AtaqueDanoInvalidoException | TipoInvalidoException | InvalidoException e) {
                            System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while(!success);
                    break;

                case "18" :
                    success = true;
                    do{
                        System.out.println("Digite o nome do hm a ser removido:");
                        try {
                            fachada.removerAtaque(in.nextLine());
                            System.out.println("Sucesso na operação");
                        } catch (AtaqueInexistenteException | InvalidoException e) {
                            System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while(!success);
                    break;

                case "19" :
                    success = true;
                    do{
                        System.out.println("Digite o nome do Ataque a ser buscado:");
                        try {
                            fachada.procurarAtaque(in.nextLine());
                            System.out.println("Sucesso na operação");
                        } catch (AtaqueInexistenteException | InvalidoException e) {
                            System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }
                    } while(!success);
                    break;

                case "20" :
                    success = true;
                    do{
                        System.out.println("Digite o nome do Ataque a ser atualizado:");
                        try {
                            Attack move = fachada.procurarAtaque(in.nextLine());
                            System.out.println("Digite o tipo, quantidade de pp, o dano e o efeito dentro da batalha, \n respectivamente, em sua própria linha:");
                            move.setType(in.nextLine());
                            move.setPP(in.nextLine());
                            move.setDamage(in.nextLine());
                            move.setEffect(in.nextLine());
                            fachada.atualizarAtaque(move);
                            System.out.println("Sucesso na operação");
                        } catch (AtaquePPInvalidoException | InvalidoException | TipoInvalidoException | AtaqueEfeitoInvalidoException | AtaqueInexistenteException | AtaqueExistenteException | AtaqueDanoInvalidoException e) {
                            System.out.println("Erro! Digite corretamente todas as informações. Digite 1(um) para tentar novamente, outro para sair");
                            int loop = in.nextInt();
                            if (loop == 1)
                                success = false;
                        }

                    } while(!success);
                    break;

                case "0" :
                        succesAll = false;
                    break;
            }
        } while (succesAll);
    }
}
