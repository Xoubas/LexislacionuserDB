package org.example.dao;

import org.example.model.Norma;

import java.util.List;

public class NormaPaginacion {
    private final NormaDAO normaDAO;
    private final int pageSize;
    private int currentPage;
    private int totalResults;

    public NormaPaginacion(NormaDAO normaDAO, int pageSize) {
        this.normaDAO = normaDAO;
        this.pageSize = pageSize;
        this.currentPage = 0;
        this.totalResults = normaDAO.countAll();
    }

    public List<Norma> getPageContent() {
        int n = pageSize * currentPage;
        return normaDAO.findByTituloContaining("", n, pageSize);
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) totalResults / pageSize);
    }

    public void nextPage() {
        if (currentPage < getTotalPages()-1) {
            currentPage++;
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage +1;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
}

