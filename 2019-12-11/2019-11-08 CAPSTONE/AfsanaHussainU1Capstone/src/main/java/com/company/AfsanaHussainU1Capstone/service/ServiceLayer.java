package com.company.AfsanaHussainU1Capstone.service;

import com.company.AfsanaHussainU1Capstone.dao.*;
import com.company.AfsanaHussainU1Capstone.exceptions.NotFoundException;
import com.company.AfsanaHussainU1Capstone.models.Consoles;
import com.company.AfsanaHussainU1Capstone.models.Games;
import com.company.AfsanaHussainU1Capstone.models.Invoice;
import com.company.AfsanaHussainU1Capstone.models.Tshirts;
import com.company.AfsanaHussainU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.GameViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.TshirtViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ServiceLayer {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtDao tshirtDao;


    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TshirtDao tshirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tshirtDao = tshirtDao;
    }


    public ConsoleViewModel saveConsole(ConsoleViewModel consoleViewModel) {
        Consoles consoles = new Consoles();
        consoles.setModel(consoleViewModel.getModel());
        consoles.setManufacturer(consoleViewModel.getManufacturer());
        consoles.setMemoryAmount(consoleViewModel.getMemoryAmount());
        consoles.setPrice(consoleViewModel.getPrice());
        consoles.setQuantity(consoleViewModel.getQuantity());
        consoles.setProccessor(consoleViewModel.getProccessor());
        consoles = consoleDao.saveConsole(consoles);

        consoleViewModel.setConsoleId(consoles.getConsoleId());
        return consoleViewModel;
    }

    public void updateConsole(ConsoleViewModel consoleViewModel) {
        Consoles consoles = new Consoles();
        consoles.setModel(consoleViewModel.getModel());
        consoles.setManufacturer(consoleViewModel.getManufacturer());
        consoles.setMemoryAmount(consoleViewModel.getMemoryAmount());
        consoles.setPrice(consoleViewModel.getPrice());
        consoles.setQuantity(consoleViewModel.getQuantity());
        consoles.setProccessor(consoleViewModel.getProccessor());

        consoleDao.updateConsole(consoles);
    }

    public ConsoleViewModel findConsolebyId(int id) {
        Consoles consoles = consoleDao.findConsoleById(id);
        if (consoles == null)
            throw new NotFoundException("Not in db");
        else
            return buildConsole(consoles);
    }

    public void deleteConsole(int id) {
        consoleDao.deleteConsoleById(id);
    }


    public GameViewModel saveGame(GameViewModel gameViewModel) {
        Games games = new Games();
        games.setTitle(gameViewModel.getTitle());
        games.setEsrbRating(gameViewModel.getEsrbRating());
        games.setStudio(gameViewModel.getStudio());
        games.setQuantity(gameViewModel.getQuantity());
        games.setDescription(gameViewModel.getDescription());
        games.setPrice(gameViewModel.getPrice());

        games = gameDao.saveGame(games);
        gameViewModel.setGameId(games.getGameId());
        return gameViewModel;
    }

    public GameViewModel findGameById(int id) {
        Games games = gameDao.findGameById(id);
        if (games == null)
            throw new NotFoundException("Not in db");
        else
            return buildGame(games);


    }

    public void deleteGameBy(int id) {
        gameDao.deleteGameById(id);
    }

    public List<GameViewModel> getAllgames() {
        return gameDao.findAllGames().stream().map(this::buildGame).collect(Collectors.toList());
    }
    public void updateGame(GameViewModel gameViewModel) {
        Games games = new Games();
        games.setGameId(gameViewModel.getGameId());
        games.setTitle(gameViewModel.getTitle());
        games.setEsrbRating(gameViewModel.getEsrbRating());
        games.setStudio(gameViewModel.getStudio());
        games.setQuantity(gameViewModel.getQuantity());
        games.setDescription(gameViewModel.getDescription());
        games.setPrice(gameViewModel.getPrice());
        gameDao.updateGame(games);
    }


    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirts tshirt = new Tshirts();
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt.setPrice(tshirtViewModel.getPrice());

        tshirt = tshirtDao.saveTshirt(tshirt);

        tshirtViewModel.setTShirtId(tshirt.getTShirtId());
        return tshirtViewModel;
    }

    public void updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirts tshirts = new Tshirts();
        tshirts.setColor(tshirtViewModel.getColor());
        tshirts.setDescription(tshirtViewModel.getDescription());
        tshirts.setSize(tshirtViewModel.getSize());
        tshirts.setPrice(tshirtViewModel.getPrice());
        tshirts.setQuantity(tshirtViewModel.getQuantity());

        tshirtDao.updateTshirt(tshirts);

    }

    public TshirtViewModel findTshirtbyId(int id) {
        Tshirts tshirts = tshirtDao.findTshirtById(id);
        if (tshirts == null)
            throw new NotFoundException("Not in db");
        else
            return buildTshirtViewModel(tshirts);
    }

    public void deleteTshirt(int id) {
        consoleDao.deleteConsoleById(id);
    }

    public InvoiceViewModel findInvoiceByInvoiceId(int id) {
        Invoice invoice = invoiceDao.findInvoiceById(id);
        if (invoice == null)
            throw new NotFoundException("not in db");
        else
            return buildInvoiceViewModel(invoice);
    }

    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(invoice.getInvoiceId());
        invoice.setProcessingFee(invoice.getProcessingFee());
        invoice.setName(invoice.getName());
        invoice.setCity(invoice.getCity());
        invoice.setState(invoice.getState());
        invoice.setQuantity(invoice.getQuantity());
        invoice.setTotal(invoice.getTotal());
        invoice.setSubtotal(invoice.getSubtotal());
        invoice.setUnitPrice(invoice.getUnitPrice());
        invoice.setItemType(invoice.getItemType());
        invoice.setZipCode(invoice.getZipCode());
        invoice.setStreet(invoice.getStreet());
        invoice.setTax(invoice.getTax());

        invoiceDao.updateInvoice(invoice);
    }
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel){
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZipCode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        boolean isOver10 = invoiceViewModel.getQuantity() >10;
        //declaration and instantiation
        Games games = new Games();
        Tshirts tshirts = new Tshirts();
        Consoles consoles = new Consoles();

        BigDecimal processingFee = null;

        //getting item types and calculating totals
        if(invoiceViewModel.getItemType().equalsIgnoreCase("Games") || invoiceViewModel.getItemType().equalsIgnoreCase("games")) {
            games =gameDao.findGameById(invoiceViewModel.getItemId());
            if (games == null)
                throw new NotFoundException("not found");

            if(invoice.getQuantity() > games.getQuantity())
                throw new IllegalArgumentException("amount ordered exceeds amount on hand");

            invoice.setSubtotal(games.getPrice().multiply(new BigDecimal(invoice.getQuantity())));
            invoiceViewModel.setSubtotal(invoice.getSubtotal());

            processingFee = new BigDecimal(processingFeeDao.getProcessingFeeByProductType(invoiceViewModel.getItemType()).getProductType());

        } else if(invoiceViewModel.getItemType().equalsIgnoreCase("tshirts")|| invoiceViewModel.getItemType().equalsIgnoreCase("Tshirts")) {
            tshirts = tshirtDao.findTshirtById(invoiceViewModel.getItemId());

            if (tshirts == null)
                throw new NotFoundException("not found");
            invoice.setSubtotal(tshirts.getPrice().multiply(new BigDecimal(invoice.getQuantity())));
            invoiceViewModel.setSubtotal(invoice.getSubtotal());

            if(invoice.getQuantity() > tshirts.getQuantity())
                throw new IllegalArgumentException("amount ordered exceeds amount on hand");

            processingFee = new BigDecimal(processingFeeDao.getProcessingFeeByProductType(invoiceViewModel.getItemType()).getProductType());

        }else if(invoiceViewModel.getItemType().equalsIgnoreCase("Consoles")|| invoiceViewModel.getItemType().equalsIgnoreCase("consoles")) {
            consoles = consoleDao.findConsoleById(invoiceViewModel.getItemId());
            if (consoles == null)
                throw new NotFoundException("could not find console");

            invoice.setSubtotal(consoles.getPrice().multiply(new BigDecimal(invoice.getQuantity())));
            invoiceViewModel.setSubtotal(invoice.getSubtotal());

            if(invoice.getQuantity() > consoles.getQuantity())
                throw new IllegalArgumentException("amount ordered exceeds amount on hand");

            processingFee = new BigDecimal(processingFeeDao.getProcessingFeeByProductType(invoiceViewModel.getItemType()).getProductType());
        }
        else throw new NotFoundException("product does not exist");

        BigDecimal tax = null;

        if (invoiceViewModel.getState().length() > 2) {
            throw new IllegalArgumentException("length of state is too long");
        } else {
            tax = salesTaxRateDao.getSalesTaxRate(invoiceViewModel.getState()).getRate().add(new BigDecimal("1.00"));
        }

        if(isOver10) processingFee=processingFee.add(new BigDecimal(15.49));

        invoice.setProcessingFee(processingFee);
        invoiceViewModel.setProcessingFee(processingFee);

        BigDecimal taxedAmount = invoice.getSubtotal().multiply(tax);

        invoice.setTax(taxedAmount);
        invoiceViewModel.setTax(taxedAmount);

        BigDecimal total = taxedAmount.add(processingFee).add(invoice.getSubtotal());

        invoice.setTotal(total);
        invoiceViewModel.setTotal(total);

           return invoiceViewModel;
    }

    public List<InvoiceViewModel> getAllInvoices(){
        return invoiceDao.findAllInvoice().stream().map(this::buildInvoiceViewModel).collect(Collectors.toList());
    }
    public void deleteInvoiceById(int id){
        invoiceDao.deleteInvoiceById(id);
    }


    private ConsoleViewModel buildConsole(Consoles console) {
        ConsoleViewModel viewModel = new ConsoleViewModel();
        viewModel.setConsoleId(console.getConsoleId());
        viewModel.setModel(console.getModel());
        viewModel.setManufacturer(console.getManufacturer());
        viewModel.setMemoryAmount(console.getMemoryAmount());
        viewModel.setPrice(console.getPrice());
        viewModel.setQuantity(console.getQuantity());
        viewModel.setProccessor(console.getProccessor());

        return viewModel;
    }


    private GameViewModel buildGame(Games games) {
        GameViewModel viewModel = new GameViewModel();
        viewModel.setGameId(games.getGameId());
        viewModel.setTitle(games.getTitle());
        viewModel.setEsrbRating(games.getEsrbRating());
        viewModel.setStudio(games.getStudio());
        viewModel.setQuantity(games.getQuantity());
        viewModel.setDescription(games.getDescription());
        viewModel.setPrice(games.getPrice());
        return viewModel;
    }

    private TshirtViewModel buildTshirtViewModel(Tshirts tshirts) {
        TshirtViewModel viewModel = new TshirtViewModel();
        viewModel.setTShirtId(tshirts.getTShirtId());
        viewModel.setColor(tshirts.getColor());
        viewModel.setDescription(tshirts.getDescription());
        viewModel.setSize(tshirts.getSize());
        viewModel.setPrice(tshirts.getPrice());
        viewModel.setQuantity(tshirts.getQuantity());
        return viewModel;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel viewModel = new InvoiceViewModel();
        viewModel.setInvoiceId(invoice.getInvoiceId());
        viewModel.setItemId(invoice.getItemId());
        viewModel.setProcessingFee(invoice.getProcessingFee());
        viewModel.setName(invoice.getName());
        viewModel.setCity(invoice.getCity());
        viewModel.setState(invoice.getState());
        viewModel.setQuantity(invoice.getQuantity());
        viewModel.setTotal(invoice.getTotal());
        viewModel.setSubtotal(invoice.getSubtotal());
        viewModel.setUnitPrice(invoice.getUnitPrice());
        viewModel.setItemType(invoice.getItemType());
        viewModel.setZipCode(invoice.getZipCode());
        viewModel.setStreet(invoice.getStreet());
        viewModel.setTax(invoice.getTax());
        return viewModel;
    }
}
