const puppeteer = require('puppeteer');
const invoiceTemplate = require('../templates/invoice.html.js');

async function generateInvoicePDF(invoice, outputPath) {
    const browser = await puppeteer.launch();
    const page = await browser.newPage();

    const html = invoiceTemplate(invoice);
    await page.setContent(html, { waitUntil: 'networkidle0' });

    await page.pdf({
        path: outputPath,
        format: 'A4',
        printBackground: true
    });

    await browser.close();
}

module.exports = { generateInvoicePDF };
