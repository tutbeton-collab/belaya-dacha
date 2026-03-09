import Header from '@/components/Header';
import Hero from '@/components/Hero';
import About from '@/components/About';
import Vegetables from '@/components/Vegetables';
import Advantages from '@/components/Advantages';
import Wholesale from '@/components/Wholesale';
import Gallery from '@/components/Gallery';
import Contact from '@/components/Contact';
import Footer from '@/components/Footer';

export default function Home() {
  return (
    <main className="min-h-screen">
      <Header />
      <Hero />
      <About />
      <Vegetables />
      <Advantages />
      <Wholesale />
      <Gallery />
      <Contact />
      <Footer />
    </main>
  );
}
