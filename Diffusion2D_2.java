class Diffusion2D{
  public static void main(String args[]){
    //初期の設定
    double dt = 0.025;
    double dx = 0.05;
    double dy = 0.05;
    double D = 0.01;
    double[][] qn = new double[201][201];
    double[][] qnp1 = new double[201][201];

    //値の代入
    for(int i = 0; i <= 200 ; i++){
      for(int j = 0; j <= 200 ; j++){
        qn[i][j] = 0.0;
      }
    }
    for(int i = 98;i <= 102 ; i++){
      for(int j = 98; j <= 102 ; j++){
        qn[i][j] = 1.0;
      }
    }

    //計算
    for(int n = 1; n <= 20;n++){
      for(int i = 0; i <= 200 ; i++){
        qn[i][0] = 0.0;
        qn[i][200] = 0.0;
      }
      for(int j = 0; j <= 200 ; j++){
        qn[0][j] = 0.0;
        qn[200][j] = 0.0;
      }
      for(int i = 1; i <= 199;i++){
        for(int j = 1; j <= 199 ; j++){
          qnp1[i][j] = qn[i][j] + (D*dt/(dx*dx))*(qn[(i+1)][j]-2.0*qn[i][j] + qn[(i-1)][j]) + (D*dt/(dy*dy))*(qn[i][(j+1)]-2.0*qn[i][j] + qn[i][(j-1)]);
          qnp1[i][j] += -0.5*(dt/dx)*(qn[(i+1)][j]-qn[(i-1)%201][j]) +0.5*(dt/dy)*(qn[i][(j+1)]-qn[i][(j-1)]);
        }
      }

      for(int i = 0 ; i <= 200; i++){
        for(int j = 0 ; j <= 200; j++){
          qn[i][j] = qnp1[i][j];

          }
        }
      }

    //結果の表示
    System.out.println("q(0.1,4.7,4.75):" + qn[94][95]);
    System.out.println("q(0.1,5.0,4.75):" + qn[100][95]);
    System.out.println("q(0.1,5.3,4.75):" + qn[106][95]);
    System.out.println("q(0.1,4.7,5.0):" + qn[94][100]);
    System.out.println("q(0.1,5.0,5.0):" + qn[100][100]);
    System.out.println("q(0.1,5.3,5.0):" + qn[106][100]);
    System.out.println("q(0.1,4.7,5.3):" + qn[94][106]);
    System.out.println("q(0.1,5.0,5.3):" + qn[100][106]);
    System.out.println("q(0.1,5.3,5.3):" + qn[106][106]);
    System.out.println("q(0.1,5.3,5.3):" + qn[0][0]);
  }
}
