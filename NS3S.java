public class NS3S {
    int cinp;
    int cout;
    int chl1;
    int chl2;
    int chl3;
    double[] inp;
    double[] hl1;
    double[] hl2;
    double[] hl3;
    double[] out;
    double[][] ves1;
    double[][] ves2;
    double[][] ves3;
    double[][] ves4;


    public NS3S(int cinp, int chl1, int chl2, int chl3, int cout){
        this.cinp = cinp;
        this.chl1 = chl1;
        this.chl2 = chl2;
        this.chl3 = chl3;
        this.cout = cout;
        inp = new double[cinp + 1];
        hl1 = new double[chl1];
        hl2 = new double[chl2];
        hl3 = new double[chl3];
        out = new double[cout];
        ves1 = new double[cinp + 1][chl1];
        ves2 = new double[chl1][chl2];
        ves3 = new double[chl2][chl3];
        ves4 = new double[chl3][cout];

        for (int i = 0; i < cinp + 1; i++) {
            for (int j = 0; j < chl1; j++) {
                if (Math.random() >= 0.5) {
                    ves1[i][j] = Math.random();
                } else {
                    ves1[i][j] = -Math.random();
                }
            }
        }

        for (int i = 0; i < chl1; i++) {
            for (int j = 0; j < chl2; j++) {
                if (Math.random() >= 0.5) {
                    ves2[i][j] = Math.random();
                } else {
                    ves2[i][j] = -Math.random();
                }
            }
        }

        for (int i = 0; i < chl2; i++) {
            for (int j = 0; j < chl3; j++) {
                if (Math.random() >= 0.5) {
                    ves3[i][j] = Math.random();
                } else {
                    ves3[i][j] = -Math.random();
                }
            }
        }

        for (int i = 0; i < chl3; i++) {
            for (int j = 0; j < cout; j++) {
                if (Math.random() >= 0.5) {
                    ves4[i][j] = Math.random();
                } else {
                    ves4[i][j] = -Math.random();
                }

            }
        }
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.pow(Math.E, -x));
    }

    private double difsigmoid(double x) {
        return x * (1 - x);
    }

    private void calc() {
        inp[cinp] = 1;

        for (int h = 0; h < chl1; h++) {
            double s = 0;
            for (int i = 0; i < cinp + 1; i++) {
                s += ves1[i][h] * inp[i];
            }
            hl1[h] = sigmoid(s);
        }

        for (int h = 0; h < chl2; h++) {
            double s = 0;
            for (int i = 0; i < chl1; i++) {
                s += ves2[i][h] * hl1[i];
            }
            hl2[h] = sigmoid(s);
        }

        for (int h = 0; h < chl3; h++) {
            double s = 0;
            for (int i = 0; i < chl2; i++) {
                s += ves3[i][h] * hl2[i];
            }
            hl3[h] = sigmoid(s);
        }

        for (int h = 0; h < cout; h++) {
            double s = 0;
            for (int i = 0; i < chl3; i++) {
                s += ves4[i][h] * hl3[i];
            }
            out[h] = sigmoid(s);
        }
    }

    private void learning(double[] answer) {
        double s;
        double H;
        double s1 = 0;
        for (int o = 0; o < cout; o++) {
            s1 += (out[o] - answer[o]) * (out[o] - answer[o]);
        }
        H = s1 / 2;

        double[] errout = new double[cout];
        for (int i = 0; i < cout; i++) {
            errout[i] = (answer[i] - out[i]) * difsigmoid(out[i]);
        }
        double[] errhl3 = new double[chl3];
        for (int i = 0; i < chl3; i++) {
            s = 0;
            for (int j = 0; j < cout; j++) {
                s += ves4[i][j] * errout[j];
            }
            errhl3[i] = s * difsigmoid(hl3[i]);
        }
        double[] errhl2 = new double[chl2];
        for (int i = 0; i < chl2; i++) {
            s = 0;
            for (int j = 0; j < chl3; j++) {
                s += ves3[i][j] * errhl3[j];
            }
            errhl2[i] = s * difsigmoid(hl2[i]);
        }
        double[] errhl1 = new double[chl1];
        for (int i = 0; i < chl1; i++) {
            s = 0;
            for (int j = 0; j < chl2; j++) {
                s += ves2[i][j] * errhl2[j];
            }
            errhl1[i] = s * difsigmoid(hl1[i]);
        }


        for (int i = 0; i < cinp + 1; i++) {
            for (int j = 0; j < chl1; j++) {
                ves1[i][j] += H * inp[i] * errhl1[j];
            }
        }
        for (int i = 0; i < chl1; i++) {
            for (int j = 0; j < chl2; j++) {
                ves2[i][j] += H * hl1[i] * errhl2[j];
            }
        }
        for (int i = 0; i < chl2; i++) {
            for (int j = 0; j < chl3; j++) {
                ves3[i][j] += H * hl2[i] * errhl3[j];
            }
        }
        for (int i = 0; i < chl3; i++) {
            for (int j = 0; j < cout; j++) {
                ves4[i][j] += H * hl3[i] * errout[j];
            }
        }
    }

    public void train(double[][] asks, double[][] answers){
        for (int i = 0; i<10; i++){
            for (int q = 0; q<asks.length; q++){
                for (int j = 0; j < cinp; j++) {
                    inp[j] = asks[q][j];
                }
                calc();
                learning(answers[q]);
            }
            //System.out.print("8");
        }
        //System.out.println("   Ready");
        System.out.println(" OK");
    }

    public void GiveAnswer() {
        for (int i = 0; i < cout; i++) {
            System.out.print(( (int)(out[i]*2))+" ");
        }
        System.out.println();
    }

    public void test(double[] ask){
        for (int j = 0; j < cinp; j++) {
            inp[j] = ask[j];
        }
        calc();
        System.out.print("NS say: ");
        GiveAnswer();
    }
}
