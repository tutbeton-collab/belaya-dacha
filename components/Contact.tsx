import Link from 'next/link';

export default function Contact() {
  return (
    <section id="contact" className="section bg-farm-cream">
      <div className="container mx-auto px-4">
        <div className="max-w-3xl mx-auto text-center">
          <h2 className="section-title">Свяжитесь с нами</h2>
          <p className="section-subtitle">
            Мы всегда рады ответить на ваши вопросы и помочь с выбором
          </p>
          
          <div className="grid md:grid-cols-2 gap-6 mt-10">
            <Link 
              href="https://max.ru/id561604822670_biz" 
              target="_blank"
              rel="noopener noreferrer"
              className="card bg-gradient-to-br from-blue-500 to-blue-600 text-white hover-lift flex flex-col items-center justify-center py-10"
            >
              <div className="text-5xl mb-4">💬</div>
              <h3 className="text-2xl font-bold mb-2">MAX</h3>
              <p className="opacity-90">Написать в мессенджер</p>
            </Link>
            
            <Link 
              href="https://t.me/bd5656" 
              target="_blank"
              rel="noopener noreferrer"
              className="card bg-gradient-to-br from-sky-400 to-sky-500 text-white hover-lift flex flex-col items-center justify-center py-10"
            >
              <div className="text-5xl mb-4">✈️</div>
              <h3 className="text-2xl font-bold mb-2">Telegram</h3>
              <p className="opacity-90">Написать в Telegram</p>
            </Link>
          </div>
          
          <div className="mt-12 p-6 bg-white rounded-2xl shadow-md">
            <p className="text-farm-brown text-lg">
              🕒 <strong>Время работы:</strong> Ежедневно с 8:00 до 20:00
            </p>
            <p className="text-farm-brown text-lg mt-2">
              📍 <strong>Адрес:</strong> Семейная ферма &quot;Белая Дача&quot;
            </p>
          </div>
        </div>
      </div>
    </section>
  );
}
