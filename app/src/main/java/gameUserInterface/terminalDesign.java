package gameUserInterface;

//--X-Y----
public class terminalDesign implements interfaceDesign{

    @Override
    public void showGame(String boardStatus) {
        if(boardStatus.isEmpty()){
            boardStatus = "         ";
        }
        String[] boardStatusAux = boardStatus.split("");
        System.out.print(" "+boardStatusAux[0]+" | "+boardStatusAux[1]+" | "+boardStatusAux[2]);
        System.out.print("\n-----------\n");
        System.out.print(" "+boardStatusAux[3]+" | "+boardStatusAux[4]+" | "+boardStatusAux[5]);
        System.out.print("\n-----------\n");
        System.out.print(" "+boardStatusAux[6]+" | "+boardStatusAux[7]+" | "+boardStatusAux[8]);

    }
}
