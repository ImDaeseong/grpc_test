using Grpc.Core;
using Myservice;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace gRPCClient
{
    public partial class Form1 : Form
    {
        private readonly MyService.MyServiceClient client;

        public Form1()
        {
            InitializeComponent();

            var channel = new Channel("localhost:10011", ChannelCredentials.Insecure);
            client = new MyService.MyServiceClient(channel);
        }


        private async void button1_Click(object sender, EventArgs e)
        {
            var request = new myRequest { Request = "button1_Click" };

            var response = await client.MyMethod1Async(request);
            Console.WriteLine(response.Response);
        }

        private async void button2_Click(object sender, EventArgs e)
        {
            var request = new myRequest { Request = "button2_Click" };

            var response = await client.MyMethod1Async(request);
            Console.WriteLine(response.Response);
        }
    }
}
