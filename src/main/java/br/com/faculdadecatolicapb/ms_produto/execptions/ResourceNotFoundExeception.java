package br.com.faculdadecatolicapb.ms_produto.execptions;

public class ResourceNotFoundExeception extends RuntimeException {
    public ResourceNotFoundExeception(String message) {
        super(message);
    }
}
