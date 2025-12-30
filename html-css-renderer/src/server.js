const express = require('express');
const bodyParser = require('body-parser');
const { generateInvoicePDF } = require('./renderer');
const path = require('path');

const app = express();
app.use(bodyParser.json());

app.post('/generate-pdf', async (req, res) => {
    const invoice = req.body;
    const outputPath = path.join(__dirname, '..', 'output', `invoice-${invoice.invoiceNumber}.pdf`);

    try {
        await generateInvoicePDF(invoice, outputPath);
        res.status(200).send({ message: 'PDF generated successfully', path: outputPath });
    } catch (err) {
        console.error(err);
        res.status(500).send({ message: 'Failed to generate PDF' });
    }
});

const PORT = 3000;
app.listen(PORT, () => {
    console.log(`HTML/CSS Renderer running on port ${PORT}`);
});
