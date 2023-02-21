package utils;

public class ConfiguracionPaginado {
    private int numeroPagina;
    private int elementosPorPagina;

    public ConfiguracionPaginado() {
        this.numeroPagina = 0;
        this.elementosPorPagina = 3;
    }

    public ConfiguracionPaginado(int numeroPagina, int elementosPorPagina) {
        this.numeroPagina = numeroPagina;
        this.elementosPorPagina = elementosPorPagina;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public int getElementosPorPagina() {
        return elementosPorPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public void setElementosPorPagina(int elementosPorPagina) {
        this.elementosPorPagina = elementosPorPagina;
    }
    
    public int getElementosASaltar() {
        return this.numeroPagina * this.elementosPorPagina;
    }
    
    public void avanzarPagina() {
        this.numeroPagina++;
    }
    
    public void retrocederPagina() {
        this.numeroPagina--;
    }
}
