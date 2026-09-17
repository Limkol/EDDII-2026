public class ArvoreRubroNegra {
    private No raiz;
    private No nulo;

    public ArvoreRubroNegra() {
        this.nulo = new No();
        this.nulo.cor = Cor.PRETO;
        this.raiz = nulo;
    }

    private void rotacaoEsquerda(No x) {
        No y = x.direita;
        x.direita = y.esquerda;

        if (y.esquerda != nulo) {
            y.esquerda.pai = x;
        }

        y.pai = x.pai;
        if (x.pai == nulo) {
            raiz = y;
        } else {
            if (x == x.pai.esquerda) {
                x.pai.esquerda = y;
            } else {
                x.pai.direita = y;
            }
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(No x) {
        No y = x.esquerda;
        x.esquerda = y.direita;

        if (y.direita != nulo) {
            y.direita.pai = x;
        }

        y.pai = x.pai;
        if (x.pai == nulo) {
            raiz = y;
        } else {
            if (x == x.pai.direita) {
                x.pai.direita = y;
            } else {
                x.pai.esquerda = y;
            }
        }

        y.direita = x;
        x.pai = y;
    }

    public void inserir(int valor) {
        No antecessor = nulo;
        No p = raiz;
        No novo;

        while (p != nulo) {
            antecessor = p;
            if (valor < p.valor) {
                p = p.esquerda;
            } else {
                p = p.direita;
            }
        }

        novo = new No(valor);
        novo.pai = antecessor;
        novo.esquerda = nulo;
        novo.direita = nulo;
        novo.cor = Cor.VERMELHO;

        if (antecessor == nulo) {
            raiz = novo;
        } else {
            if (valor < antecessor.valor) {
                antecessor.esquerda = novo;
            } else {
                antecessor.direita = novo;
            }
        }

        restaurarPropriedades(novo);
    }

    private void restaurarPropriedades(No x) {
        No y;

        while (x.pai.cor == Cor.VERMELHO) {
            if (x.pai == x.pai.pai.esquerda) {
                y = x.pai.pai.direita;

                if (y.cor == Cor.VERMELHO) {
                    x.pai.cor = Cor.PRETO;
                    y.cor = Cor.PRETO;
                    x.pai.pai.cor = Cor.VERMELHO;
                    x = x.pai.pai;
                } else {
                    if (x == x.pai.direita) {
                        x = x.pai;
                        rotacaoEsquerda(x);
                    }
                    x.pai.cor = Cor.PRETO;
                    x.pai.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(x.pai.pai);
                }
            } else {
                y = x.pai.pai.esquerda;

                if (y.cor == Cor.VERMELHO) {
                    x.pai.cor = Cor.PRETO;
                    y.cor = Cor.PRETO;
                    x.pai.pai.cor = Cor.VERMELHO;
                    x = x.pai.pai;
                } else {
                    if (x == x.pai.esquerda) {
                        x = x.pai;
                        rotacaoDireita(x);
                    }
                    x.pai.cor = Cor.PRETO;
                    x.pai.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(x.pai.pai);
                }
            }
        }

        raiz.cor = Cor.PRETO;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No no, int valor) {
        if (no == nulo) {
            return false;
        }

        if (valor == no.valor) {
            return true;
        } else if (valor < no.valor) {
            return buscarRecursivo(no.esquerda, valor);
        } else {
            return buscarRecursivo(no.direita, valor);
        }
    }

    public void exibirEmOrdem() {
        System.out.print("Árvore em ordem: ");
        exibirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No no) {
        if (no != nulo) {
            exibirEmOrdemRecursivo(no.esquerda);
            System.out.print("[" + no.valor + "(" + no.cor + ")] ");
            exibirEmOrdemRecursivo(no.direita);
        }
    }

    public void exibirArvore() {
        System.out.println("\nEstrutura da árvore:");
        exibirArvoreRecursivo(raiz, "", true);
    }

    private void exibirArvoreRecursivo(No no, String prefixo, boolean ehUltimo) {
        if (no != nulo) {
            System.out.println(prefixo + (ehUltimo ? "└── " : "├── ") + 
                             no.valor + "(" + no.cor + ")");
            String novaLinha = prefixo + (ehUltimo ? "    " : "│   ");

            if (no.esquerda != nulo || no.direita != nulo) {
                if (no.esquerda != nulo) {
                    exibirArvoreRecursivo(no.esquerda, novaLinha, no.direita == nulo);
                } else {
                    System.out.println(novaLinha + "├── null(PRETO)");
                }

                if (no.direita != nulo) {
                    exibirArvoreRecursivo(no.direita, novaLinha, true);
                } else {
                    System.out.println(novaLinha + "└── null(PRETO)");
                }
            }
        }
    }

    public int calcularAlturaNegra() {
        return calcularAlturaNegra(raiz);
    }

    private int calcularAlturaNegra(No no) {
        if (no == nulo) {
            return 1;
        }

        int alturaEsq = calcularAlturaNegra(no.esquerda);
        int alturaDir = calcularAlturaNegra(no.direita);

        if (alturaEsq == -1 || alturaDir == -1 || alturaEsq != alturaDir) {
            return -1;
        }

        if (no.cor == Cor.PRETO) {
            return alturaEsq + 1;
        } else {
            return alturaEsq;
        }
    }

    public boolean verificarPropriedades() {
        if (raiz.cor != Cor.PRETO) {
            System.out.println("ERRO: Raiz não é preta!");
            return false;
        }

        if (calcularAlturaNegra(raiz) == -1) {
            System.out.println("ERRO: Altura negra inconsistente!");
            return false;
        }

        if (!verificarVermelhos(raiz)) {
            System.out.println("ERRO: Encontrados dois nós vermelhos consecutivos!");
            return false;
        }

        return true;
    }

    private boolean verificarVermelhos(No no) {
        if (no == nulo) {
            return true;
        }

        if (no.cor == Cor.VERMELHO) {
            if (no.esquerda.cor == Cor.VERMELHO || no.direita.cor == Cor.VERMELHO) {
                return false;
            }
        }

        return verificarVermelhos(no.esquerda) && verificarVermelhos(no.direita);
    }

    public int getTamanhoDaArvore() {
        return getTamanhoDaArvore(raiz);
    }

    private int getTamanhoDaArvore(No no) {
        if (no == nulo) {
            return 0;
        }
        return 1 + getTamanhoDaArvore(no.esquerda) + getTamanhoDaArvore(no.direita);
    }

    public int getAltura() {
        return getAltura(raiz);
    }

    private int getAltura(No no) {
        if (no == nulo) {
            return 0;
        }
        return 1 + Math.max(getAltura(no.esquerda), getAltura(no.direita));
    }
}