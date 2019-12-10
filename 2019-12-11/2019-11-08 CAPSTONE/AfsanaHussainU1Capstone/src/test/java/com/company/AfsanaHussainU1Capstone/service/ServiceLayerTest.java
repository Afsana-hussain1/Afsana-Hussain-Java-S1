package com.company.AfsanaHussainU1Capstone.service;

import com.company.AfsanaHussainU1Capstone.dao.*;
import com.company.AfsanaHussainU1Capstone.models.*;
import com.company.AfsanaHussainU1Capstone.viewmodel.ConsoleViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.GameViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.InvoiceViewModel;
import com.company.AfsanaHussainU1Capstone.viewmodel.TshirtViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceLayerTest {

    ServiceLayer serviceLayer;

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtDao tshirtDao;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpTshirtDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();


        serviceLayer = new ServiceLayer(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tshirtDao);
    }

    private void setUpConsoleDaoMock() {
        consoleDao = mock(ConsoleDaoImple.class);

        Consoles consoles = new Consoles();
        consoles.setConsoleId(1);
        consoles.setModel("any");
        consoles.setManufacturer("any manufact");
        consoles.setMemoryAmount("8 gb");
        consoles.setPrice(new BigDecimal(20.99).setScale(2, RoundingMode.HALF_UP));
        consoles.setQuantity(2);
        consoles.setProccessor("gb1");

        Consoles consoles1 = new Consoles();
        consoles1.setModel("any");
        consoles1.setManufacturer("any manufact");
        consoles1.setMemoryAmount("8 gb");
        consoles1.setPrice(new BigDecimal(20.99).setScale(2, RoundingMode.HALF_UP));
        consoles1.setQuantity(2);
        consoles1.setProccessor("gb1");

        List<Consoles> consolesList = new ArrayList<>();
        consolesList.add(consoles);

        doReturn(consoles).when(consoleDao).saveConsole(consoles1);
        doReturn(consoles).when(consoleDao).findConsoleById(1);
        doReturn(consolesList).when(consoleDao).findAllConsoles();

    }

    private void setUpGameDaoMock() {
        gameDao = mock(GameDaoImple.class);

        Games games = new Games();
        games.setGameId(1);
        games.setTitle("title");
        games.setEsrbRating("M");
        games.setStudio("Studio deen");
        games.setQuantity(1);
        games.setDescription("Adventure");
        games.setPrice(new BigDecimal(21.99).setScale(2, RoundingMode.HALF_UP));

        Games games1 = new Games();
        games1.setTitle("title");
        games1.setEsrbRating("M");
        games1.setStudio("Studio deen");
        games1.setQuantity(1);
        games1.setDescription("Adventure");
        games1.setPrice(new BigDecimal(21.99).setScale(2, RoundingMode.HALF_UP));


        List<Games> gamesList = new ArrayList<>();
        gamesList.add(games);

        doReturn(games).when(gameDao).saveGame(games1);
        doReturn(games).when(gameDao).findGameById(1);
        doReturn(gamesList).when(gameDao).findAllGames();
        doReturn(gamesList).when(gameDao).findGameByRating("M");
        doReturn(gamesList).when(gameDao).findGameByTitle("Metal gear solid");
        doReturn(gamesList).when(gameDao).findGameByStudio("studio deen");

    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoImple.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(4);
        invoice.setItemId(3);
        invoice.setProcessingFee(new BigDecimal("1.49").setScale(2, RoundingMode.HALF_UP));
        invoice.setName("bob");
        invoice.setCity("new york");
        invoice.setState("NY");
        invoice.setQuantity(1);
        invoice.setTotal(new BigDecimal(29.99).setScale(2, RoundingMode.HALF_UP));
        invoice.setSubtotal(new BigDecimal(20.99).setScale(2, RoundingMode.HALF_UP));
        invoice.setUnitPrice(new BigDecimal(15.99).setScale(2, RoundingMode.HALF_UP));
        invoice.setItemType("tshirt");
        invoice.setZipCode("07071");
        invoice.setStreet("main ave");
        invoice.setTax(new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP));

        Invoice invoice1 = new Invoice();
        invoice1.setItemId(3);
        invoice1.setProcessingFee(new BigDecimal("1.49").setScale(2, RoundingMode.HALF_UP));
        invoice1.setName("bob");
        invoice1.setCity("new york");
        invoice1.setState("NY");
        invoice1.setQuantity(1);
        invoice1.setTotal(new BigDecimal(29.99).setScale(2, RoundingMode.HALF_UP));
        invoice1.setSubtotal(new BigDecimal(20.99).setScale(2, RoundingMode.HALF_UP));
        invoice1.setUnitPrice(new BigDecimal(15.99).setScale(2, RoundingMode.HALF_UP));
        invoice1.setItemType("tshirt");
        invoice1.setZipCode("07071");
        invoice1.setStreet("main ave");
        invoice1.setTax(new BigDecimal(1.99).setScale(2, RoundingMode.HALF_UP));


        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);


        doReturn(invoice).when(invoiceDao).saveInvoice(invoice1);
        doReturn(invoice).when(invoiceDao).findInvoiceById(1);
        doReturn(invoiceList).when(invoiceDao).findAllInvoice();

    }

    public void setUpTshirtDaoMock() {
        tshirtDao = mock(TshirtDaoImple.class);

        Tshirts tshirts = new Tshirts();
        tshirts.setTShirtId(1);
        tshirts.setSize("Medium");
        tshirts.setDescription("loose fit");
        tshirts.setColor("Blue");
        tshirts.setPrice(new BigDecimal(9.99).setScale(2, RoundingMode.HALF_UP));
        tshirts.setQuantity(1);

        Tshirts tshirts1 = new Tshirts();
        tshirts1.setSize("Medium");
        tshirts1.setDescription("loose fit");
        tshirts1.setColor("Blue");
        tshirts1.setPrice(new BigDecimal(9.99).setScale(2, RoundingMode.HALF_UP));
        tshirts1.setQuantity(1);

        List<Tshirts> tshirtsList = new ArrayList<>();
        tshirtsList.add(tshirts);


        doReturn(tshirts).when(tshirtDao).findTshirtById(1);
        doReturn(tshirts).when(tshirtDao).saveTshirt(tshirts1);
        doReturn(tshirtsList).when(tshirtDao).findAllTshirts();
        doReturn(tshirtsList).when(tshirtDao).findTShirtBySize("Medium");
        doReturn(tshirtsList).when(tshirtDao).findTShirtByColor("Blue");

    }

    public void setUpProcessingFeeDaoMock() {

        processingFeeDao = mock(ProcessingFeeDaoImple.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP));
        processingFee.setProductType("T-shirt");

        ProcessingFee processingFee1 = new ProcessingFee();
        processingFee1.setFee(new BigDecimal(1.98).setScale(2, RoundingMode.HALF_UP));
        processingFee1.setProductType("T-shirt");

        List<ProcessingFee> processingFeeList = new ArrayList<>();
        processingFeeList.add(processingFee);

        doReturn(processingFee).when(processingFeeDao).getProcessingFeeByProductType("T-shirt");
        doReturn(processingFee).when(processingFeeDao).saveProcessingFee(processingFee1);

    }

    public void setUpSalesTaxRateDaoMock() {
        salesTaxRateDao = mock(SalesTaxRateDaoImple.class);

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NY");
        salesTaxRate.setRate(new BigDecimal(0.06).setScale(2, RoundingMode.HALF_UP));

        SalesTaxRate salesTaxRate1 = new SalesTaxRate();
        salesTaxRate1.setState("NY");
        salesTaxRate1.setRate(new BigDecimal(0.06).setScale(2, RoundingMode.HALF_UP));

        List<SalesTaxRate> salesTaxRateList = new ArrayList<>();
        salesTaxRateList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NY");

    }

    @Test
    public void shouldSaveAndFindConsole() {
        ConsoleViewModel consoles = new ConsoleViewModel();
        consoles.setConsoleId(1);
        consoles.setModel("any");
        consoles.setManufacturer("any manufact");
        consoles.setMemoryAmount("8 gb");
        consoles.setPrice(new BigDecimal(20.99).setScale(2, RoundingMode.HALF_UP));
        consoles.setQuantity(2);
        consoles.setProccessor("gb1");

        consoles = serviceLayer.saveConsole(consoles);
        ConsoleViewModel fromService = serviceLayer.findConsolebyId(consoles.getConsoleId());
        assertEquals(consoles, fromService);
    }


    @Test
    public void shouldSaveAndFindGame() {

        GameViewModel games = new GameViewModel();
        games.setGameId(1);
        games.setTitle("title");
        games.setEsrbRating("M");
        games.setStudio("Studio deen");
        games.setQuantity(1);
        games.setDescription("Adventure");
        games.setPrice(new BigDecimal(21.99).setScale(2, RoundingMode.HALF_UP));


        games = serviceLayer.saveGame(games);
        GameViewModel fromService = serviceLayer.findGameById(games.getGameId());
        assertEquals(games, fromService);

    }

    @Test
    public void shouldSaveAndFindTshirt() {
        TshirtViewModel tshirts = new TshirtViewModel();
        tshirts.setTShirtId(1);
        tshirts.setSize("Medium");
        tshirts.setDescription("loose fit");
        tshirts.setColor("Blue");
        tshirts.setPrice(new BigDecimal(9.99).setScale(2, RoundingMode.HALF_UP));
        tshirts.setQuantity(1);

        tshirts = serviceLayer.saveTshirt(tshirts);
        TshirtViewModel fromService = serviceLayer.findTshirtbyId(tshirts.getTShirtId());
        assertEquals(tshirts, fromService);

    }

//    @Test
//    public void shouldSaveAndFindInvoice(){
//        InvoiceViewModel invoice = new InvoiceViewModel();
//        invoice.setInvoiceId(1);
//        invoice.setProcessingFee(new BigDecimal(1.99).setScale(2,RoundingMode.HALF_UP);
//        invoice.setName("bob");
//        invoice.setCity(invoice.getCity());
//        invoice.setState(invoice.getState());
//        invoice.setQuantity(invoice.getQuantity());
//        invoice.setTotal(invoice.getTotal());
//        invoice.setSubtotal(invoice.getSubtotal());
//        invoice.setUnitPrice(invoice.getUnitPrice());
//        invoice.setItemType(invoice.getItemType());
//        invoice.setZipCode(invoice.getZipCode());
//        invoice.setStreet(invoice.getStreet());
//        invoice.setTax(invoice.getTax());

}
